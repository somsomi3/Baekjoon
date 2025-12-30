import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        //카운팅 배열
        int[] cnt = new int[N + 1];
 
        //1번 부터 시작
        int cur = 1;
        
        //1번에 1을 넣고 1번부터 시작
        cnt[1] = 1;
        
        int ans = 0;

        //cur을 잡고, cnt안의 cur을 이동 시키는 게 핵심이다.// 내가 했던for문은 cur을 무조건 i++해서 다 증가 시키는 건데, 여긴
        //while을 사용함으로 써, while문 안에서 cur을 자유롭게 수정한다.
        while (cnt[cur] < M) {//현재cur의 cnt가 <M인경우만 while안에서 계산을 한다.
            if (cnt[cur] % 2 == 1) {
                cur += L;//1-index라서 cnt에 +-N을 사용한다. 0-index라면 %N을 사용하는 것이다.
                if (cur > N) cur -= N;
            } else {
                cur -= L;
                if (cur <= 0) cur += N;
            }
            cnt[cur]++;
            ans++;
        }

        System.out.println(ans);
    }
}
