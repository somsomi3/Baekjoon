import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		int sum =0;
		int x =1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i =1; i<=N; i++) {
			if(arr[i]==1&& arr[i-1]==1) {
				x +=1;
				sum+= x;
			}
			else if(arr[i]==1&& arr[i-1]==0) {
				x=1;
				sum+=x;
			}else {
				continue;
			}
		}
		System.out.println(sum);
	}
}