import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        long sum = 0;
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			
		}
		
		int cluster = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			//예외처리
			//파일의 크기는 1,000,000,000보다 작거나 같은 음이 아닌 정수이다. 
			if(arr[i]==0)continue;
			else if(arr[i]>=cluster) {
				if(arr[i]%cluster==0) {
					int x = arr[i]/cluster;
					sum+=x;
				}else {
					int x = arr[i]/cluster+1;
					sum+=x;
				}
			}else sum+=1;
		}
		
		System.out.println(sum*cluster);
	}
}
