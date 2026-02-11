import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 9;
		
		int[] arr = new int[N];
		int[] brr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}

		int sumA = 0;
		int sumB = 0;
		boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			sumA += arr[i];			
			if(sumA>sumB) flag = true;
			sumB += brr[i];
			
		}
		if(flag)System.out.println("Yes");
		else System.out.println("No");
	}
}
