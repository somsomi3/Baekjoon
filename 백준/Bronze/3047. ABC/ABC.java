import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int X = Integer.parseInt(st.nextToken());
//		int Y = Integer.parseInt(st.nextToken());
//		int Z = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[3];
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int A = arr[0];
		int B = arr[1];
		int C = arr[2];
		
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<3; i++) {
			char c = s.charAt(i);
			if(c=='A') sb.append(A).append(" ");
			else if(c=='B') sb.append(B).append(" ");
			else if(c=='C') sb.append(C).append(" ");
		}
		System.out.println(sb);
	}
}