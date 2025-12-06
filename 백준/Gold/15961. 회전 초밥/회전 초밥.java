import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());//초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());//연속해서 먹는 접시수
		int c = Integer.parseInt(st.nextToken());//쿠폰번호

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int[] count = new int[d+1];// 초밥은 1번부터 시작인듯
		
		int cnt = 0;

		//접시 갯수 k만큼 채워보자
        for(int i =0; i<k; i++) {
            if(count[arr[i]] == 0) {
                cnt++;
            }
            count[arr[i]]++;
        }
        int result = cnt;
        if(count[c] == 0) result++;
		for(int i=1; i<N; i++) {
            int remove = arr[i-1];
            count[remove]--;
            if(count[remove] == 0) cnt--;

            int add = arr[(i+k-1) % N];
            if(count[add] == 0) cnt++;
            count[add]++;

            int temp = cnt;
            if(count[c] == 0) temp++;

            result = Math.max(result, temp);
		}
        System.out.println(result);
    }
}