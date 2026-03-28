import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		int sum = 0;
		int max = 0;
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			sum+= arr[i];
            max = Math.max(max, arr[i]);
		}
		
		//강의는 순서대로 담아야함. 그리고 배열안에서 값을 고를 필요없음.
//		Arrays.sort(arr);
		
        int left = max;//mid로 나눌일은 없다.
		int right = sum;
		int ans = 0;
		
		while(left<= right) {//특점 값을 찾는다.
			int mid = (left + right) /2;
			
			//M개 이하!!
			if(canFind(mid) <= M) {
				ans = mid;
				right = mid -1;//더작은 mid를 향해 가므로, ans에 Math.min은 필요없다.
			}else {
				left = mid+1;
			}
		}
		System.out.println(ans);
	}
	static int canFind(int target) {
	    int cnt = 1;
	    int sum = 0;
	
	    for(int i = 0; i < N; i++) {
	        if(sum + arr[i] > target) {
	            cnt++;
	            sum = arr[i];
	        } else {
	            sum += arr[i];
	        }
	    }
	    return cnt;
	}
}
