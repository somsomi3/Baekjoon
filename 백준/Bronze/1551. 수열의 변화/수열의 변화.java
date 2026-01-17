import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), ",");
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st2.nextToken());
		}
		
		for(int k=0; k<K; k++) {
			int[] next = new int[arr.length-1];
			for(int i =0; i<arr.length-1; i++) {
				next[i] = arr[i+1]-arr[i];
			}
			arr= next;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
            if (i + 1 < arr.length) sb.append(",");
		}
		System.out.println(sb);
	}
}
