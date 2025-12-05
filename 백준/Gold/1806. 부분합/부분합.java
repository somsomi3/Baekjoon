import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		
        int max = sum;
        int start =0;
        int min=100001;
        for(int i=0; i<N; i++) {
//            if(sum<K)sum += arr[i];
        	sum += arr[i];
            while(sum >= K) {
            	if(min>(i-start+1))min=(i-start+1);
            	sum -= arr[start];
            	start++;
            }

		}
//		System.out.println(min);
        System.out.println(min == 100001 ? 0 : min);
	}
}