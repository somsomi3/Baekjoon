import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1]; //1번 부터 시작되는 바구니 번호.
		
		for(int a=0; a<M; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int b =i; b<=j; b++) {
				arr[b]= k;
			}
		}
		for(int c=1; c<=N; c++) {
			System.out.print(arr[c]+ " ");
		}
		
	}
}