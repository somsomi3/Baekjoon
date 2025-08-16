import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = deque.indexOf(target);
            int halfIdx = deque.size() / 2;

            if (idx <= halfIdx) {
                // 왼쪽 회전 (2번 연산)
                while (deque.getFirst() != target) {
                    deque.addLast(deque.removeFirst());
                    count++;
                }
            } else {
                // 오른쪽 회전 (3번 연산)
                while (deque.getFirst() != target) {
                    deque.addFirst(deque.removeLast());
                    count++;
                }
            }

            // 맨 앞 제거 (1번 연산, 카운트 X)
            deque.removeFirst();
        }

        System.out.println(count);
    }
}
