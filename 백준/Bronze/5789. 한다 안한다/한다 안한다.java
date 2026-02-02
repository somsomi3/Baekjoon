import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String S = br.readLine();
			int N = S.length();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				int x = S.charAt(i)-'0';
				arr[i]=x;
			}
			
			if(arr[N/2-1]==arr[N/2])System.out.println("Do-it");
			else System.out.println("Do-it-Not");
		}

	}
}
