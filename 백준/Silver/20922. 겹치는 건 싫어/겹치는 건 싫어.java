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
		
		
		int[] count = new int[1000001];//count할 arr의 숫자들이 a<=1000000개
		int left=0, right =0;
		int ss = 0;
		while(true) {
			if(right==N) break;
			if(count[arr[right]]<K) {
				count[arr[right]]++;
				right++;
				ss = Math.max(ss, right- left);
			}else {
				count[arr[left]]--;
				left++;
			}
			
		}
		System.out.println(ss);
	}

}
