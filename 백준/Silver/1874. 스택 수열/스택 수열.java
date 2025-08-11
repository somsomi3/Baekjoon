import java.io.*;

public class Main {
    static final int BUF = 1 << 16;
    static final byte[] buffer = new byte[BUF];
    static int idx = 0, size = 0;
    static int read() throws IOException {
        if (idx >= size) {
            size = System.in.read(buffer);
            idx = 0;
            if (size < 0) return -1;
        }
        return buffer[idx++];
    }
    static int readInt() throws IOException {
        int c, x = 0, sign = 1;
        do { c = read(); } while (c <= 32);
        if (c == '-') { sign = -1; c = read(); }
        while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
        return x * sign;
    }

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] stack = new int[n];
        int top = 0;
        int next = 1;                  // 다음에 push 할 수
        StringBuilder sb = new StringBuilder(n * 2 + 10);

        for (int i = 0; i < n; i++) {
            int target = readInt();

            // target에 도달할 때까지 1씩 증가시키며 push
            while (next <= target) {
                stack[top++] = next++;
                sb.append('+').append('\n');
            }

            // 스택의 top이 target이면 pop, 아니면 불가능
            if (top == 0 || stack[top - 1] != target) {
                System.out.print("NO");
                return;
            }
            top--;
            sb.append('-').append('\n');
        }
        System.out.print(sb);
    }
}
