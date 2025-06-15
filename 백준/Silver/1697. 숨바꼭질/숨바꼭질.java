import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 수빈이 위치
        int K = Integer.parseInt(st.nextToken());  // 동생 위치

        int[] time = new int[MAX]; // 방문 여부 및 걸린 시간 저장용

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);  // 시작점
        time[N] = 1;     // 0초가 아닌 1로 초기화해서 나중에 -1 해서 출력

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                System.out.println(time[now] - 1);  // 실제 걸린 시간은 -1
                return;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next >= 0 && next < MAX && time[next] == 0) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
