import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		//항상 가능한 점만 존재하는가.?...
		
		HashSet<Integer>set1 = new HashSet<>();
		HashSet<Integer>set2 = new HashSet<>();
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(set1.contains(a))set1.remove(a);
			else set1.add(a);
			
			if(set2.contains(b))set2.remove(b);
			else set2.add(b);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int x : set1) {
			sb.append(x).append(" ");
		}
		for (int x : set2) {
			sb.append(x);
		}
		
		System.out.println(sb);
	}
}
