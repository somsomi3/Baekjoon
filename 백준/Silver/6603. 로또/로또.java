import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] path;

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0"))break;
			StringTokenizer st = new StringTokenizer(s);
			
			N = Integer.parseInt(st.nextToken());
			
			path = new int[N];
			arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println();
		}
		
		
	}
	static void dfs(int start, int depth) {
		if(depth==6) {
			for(int i = 0; i < 6; i++) {
	            System.out.print(path[i] + " ");
	        }
	        System.out.println();
	        return;
	    }
		
		for(int i = start; i<N ; i++) {
			path[depth] = arr[i];  
			dfs(i+1, depth+1);
		}
	}
}