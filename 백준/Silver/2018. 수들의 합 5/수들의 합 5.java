import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		for(int i =1; i<=N; i++) {
			arr[i]= i;
		}
		int left = 1;
        int right = 1;
        int sum = 1;
		int count =0;
//		for(int i =0; i<N; i++) {
//			if(right==N)break;

        while (left <= N && right <= N) {
			if(sum>N) {
				sum-=arr[left];//포함된걸 빼고
				left++;
			}else if(sum<N) {
				right++;//안포함된걸 더한다.
				sum+= arr[right];
			}else {
				count++;//이게 먼저
				sum-=arr[left];
				left++;
			}
		}
		System.out.println(count);
	}
}