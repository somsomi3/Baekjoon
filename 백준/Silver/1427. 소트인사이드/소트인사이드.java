import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		int z = s.length();
//		System.out.println(z);
		int[] arr = new int[z];
		for(int i=0; i<z; i++) {
			int A = s.charAt(i) - '0';
			arr[i] = A;
		}
		
		Arrays.sort(arr);
		
//		System.out.println(arr);
		
		for(int i = z - 1; i >= 0; i--) {
		    System.out.print(arr[i]);
		}
//
//		StringBuilder sb = new StringBuilder();
//		for(int i =z-1; i>=0; i--) {
//			sb.append(arr[i]);
//		}	
//		System.out.println(sb.toString());
	}
}