import java.io.*;

public class Main {
    static int readInt() throws IOException {
        int c, n = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32) ; 
        if (c == '-') { neg = true; c = System.in.read(); }
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return neg ? -n : n;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder out = new StringBuilder();
        int T = readInt();

        while (T-- > 0) {
            int n = readInt();
            int m = readInt();

            // 원형 큐
            int cap = 2 * n + 5;
            int[] q = new int[cap];
            int head = 0, tail = 0, size = 0;

            // 중요도 빈도
            int[] freq = new int[10];

            for (int i = 0; i < n; i++) {
                int p = readInt();
                q[tail] = p;
                tail = (tail + 1) % cap;
                size++;
                freq[p]++;
            }

            // 현재 최고 중요도
            int currentMax = 9;
            while (currentMax > 0 && freq[currentMax] == 0) currentMax--;

            int printed = 0;

            while (size > 0) {
                int p = q[head];
                head = (head + 1) % cap;
                size--;

                if (p == currentMax) { // 인쇄
                    printed++;
                    freq[p]--;

                    if (m == 0) {
                        out.append(printed).append('\n');
                        break;
                    } else {
                        m--;
                    }

                    if (freq[currentMax] == 0) {
                        while (currentMax > 0 && freq[currentMax] == 0) currentMax--;
                    }
                } else { // 뒤로 보내기
                    q[tail] = p;
                    tail = (tail + 1) % cap;
                    size++;
                    m = (m == 0 ? size - 1 : m - 1);
                }
            }
        }
        System.out.print(out.toString());
    }
}
