import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b= find(b);
		if(a !=b )parent[b]=a;
	}
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());

	        parent = new int[n + 1];
	        for (int i = 0; i <= n; i++) parent[i] = i;
	        
	        st = new StringTokenizer(br.readLine());
	        int trust = Integer.parseInt(st.nextToken());
	        int[] personNum = new int[trust];
	        for(int i =0; i<trust; i++) {
	        	personNum[i] = Integer.parseInt(st.nextToken());
	        }
	        

            //1. 유니온 한다.
	        List<int[]> parties = new ArrayList<>();
	        for (int i = 0; i < m; i++) {
	            st = new StringTokenizer(br.readLine());
	            int cnt = Integer.parseInt(st.nextToken());
	            
	            int[] people = new int[cnt];
	            for (int j = 0; j < cnt; j++) people[j] = Integer.parseInt(st.nextToken());
	            parties.add(people);
	            for (int j = 1; j < cnt; j++) 
	            	union(people[0], people[j]);
	        }
	        //2. find한다
	        //trust안에 있는 사람들을 find해보자!
	        int count = 0;
	        for (int[] party : parties) {
	        	boolean possible = true;
	        	for(int t: personNum) {
	        		if(find(t)==find(party[0])) {
	        			possible = false;
	                    break;
	                }
	            }
	            if (possible) count++;
	        }

	        System.out.println(count);
	    }
	}