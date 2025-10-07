import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹을 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 초밥 번호

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
		
		//1. 입력을 받는다.
		//2. 원형 배열을 처리한다.
		//3. 쿠폰 처리를 한다.
		
		//1. 입력을 받는다.
		//윈도우에 초밥이 몇 개 들어있을까?
		
		// 윈도우를 만들자! 윈도우가 움직이면서, 범위내에서의 초밥 만!! 센다
		int[] count = new int[d+1];
		int distinct = 0;
		
		for(int i =0; i<k; i++) {
			if(count[arr[i]]== 0) distinct++;
			count[arr[i]]++;
		}
		//3. 쿠폰 처리를 한다.
        int max = distinct;
        if (count[c] == 0) max++; // 쿠폰 초밥이 없으면 보너스 +1

		
        //2. 원형 배열을 처리한다.
		//다음이라는 것을 "항시"원형으로 처리한다!!
		for (int i = 1; i < N; i++) {  // i는 윈도우의 '시작 위치';; i가 현재 초밥이다!!!
		    //정의
			int remove = arr[i - 1];         // 한 칸 전의 왼쪽 초밥이 빠짐
		    int add = arr[(i + k - 1) % N];  // 새로 들어올 오른쪽 초밥
		    
		    //제거
		    count[remove]--;
		    if(count[remove] ==0)distinct--;
		    
		    //오른쪽에 추가
		    if(count[add]==0)distinct++;
		    count[add]++;
		    
			//3. 쿠폰 처리를 한다.
            int current = distinct;
            if (count[c] == 0) current++; // 쿠폰 보너스

		    max = Math.max(max, current);
		}
        System.out.println(max);
	}

}
