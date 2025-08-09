import java.io.*;

public class Main {
    static final int MAX = 10000;
    static final int QSIZE = 1 << 14; // 큐 크기 (16384)
    static final int MASK = QSIZE - 1; // 인덱스 wrap용 비트마스크
    static int[] queue = new int[QSIZE];
    static int head, tail;

    static int[] parent = new int[MAX];
    static char[] how = new char[MAX];

    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = read();
        while (T-- > 0) {
            int start = read();
            int target = read();
            bfs(start, target);

            // 경로 복원
            char[] buf = new char[15];
            int idx = 15;
            for (int cur = target; cur != start; cur = parent[cur]) {
                buf[--idx] = how[cur];
            }
            output.append(buf, idx, 15 - idx).append('\n');
        }
        System.out.print(output);
    }

    static void bfs(int start, int target) {
        // 초기화
        head = tail = 0;
        for (int i = 0; i < MAX; i++) parent[i] = -1;

        parent[start] = start;
        enqueue(start);

        while (head != tail) {
            int num = dequeue();

            // D
            int d = (num * 2) % 10000;
            if (parent[d] == -1) {
                parent[d] = num;
                how[d] = 'D';
                if (d == target) return;
                enqueue(d);
            }

            // S
            int s = (num == 0) ? 9999 : num - 1;
            if (parent[s] == -1) {
                parent[s] = num;
                how[s] = 'S';
                if (s == target) return;
                enqueue(s);
            }

            // L
            int l = (num % 1000) * 10 + (num / 1000);
            if (parent[l] == -1) {
                parent[l] = num;
                how[l] = 'L';
                if (l == target) return;
                enqueue(l);
            }

            // R
            int r = (num % 10) * 1000 + (num / 10);
            if (parent[r] == -1) {
                parent[r] = num;
                how[r] = 'R';
                if (r == target) return;
                enqueue(r);
            }
        }
    }

    // 원형 큐 enqueue
    static void enqueue(int x) {
        queue[head = (head + 1) & MASK] = x;
    }

    // 원형 큐 dequeue
    static int dequeue() {
        return queue[tail = (tail + 1) & MASK];
    }

    // 빠른 입력
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
