import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		int[] count = new int[N];?
		int[] count = new int[100001];
		int left=0, right =0;
		
		long ss = 0;  //ss: 경우의 수
		
        while (right < N) {
			if(count[arr[right]]==0) {
                count[arr[right]]++;
				right++;
                ss += (right - left);
			}else {
                count[arr[left]]--;
                left++;
			}
		}
        System.out.println(ss);
	}
}
