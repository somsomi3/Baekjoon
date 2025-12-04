import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] brr = new int[N];
		
		int mina = 10001;
		int maxa = -10001;
		int minb = 10001;
		int maxb = -10001;
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i]  = Integer.parseInt(st.nextToken());
			if(arr[i]<mina)mina =arr[i];
			if(arr[i]>maxa)maxa =arr[i];
			brr[i] = Integer.parseInt(st.nextToken());
			if(brr[i]<minb)minb = brr[i];
			if(brr[i]>maxb)maxb = brr[i];
		}
		
		System.out.println((maxa-mina)*(maxb-minb));
	}
}
