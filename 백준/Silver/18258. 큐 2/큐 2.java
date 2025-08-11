import java.io.*;

public class Main {
    static final int BUF_SIZE = 1 << 16;
    static final byte[] in = new byte[BUF_SIZE];
    static int p = 0, len = 0;

    static int read() throws IOException {
        if (p >= len) {
            len = System.in.read(in);
            p = 0;
            if (len <= 0) return -1;
        }
        return in[p++];
    }

    static int readInt() throws IOException { // 공백/개행 건너뛰고 정수 읽기
        int c, s = 1, x = 0;
        while ((c = read()) <= 32) if (c == -1) return -1;
        if (c == '-') { s = -1; c = read(); }
        while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
        return x * s;
    }

    // 명령 파싱: 0=push,1=pop,2=size,3=empty,4=front,5=back
    static int lastVal;
    static int readCmd() throws IOException {
        int c;
        while ((c = read()) <= 32) if (c == -1) return -1; // 첫 글자
        if (c == 'p') {                 // push or pop
            int c2 = read();
            if (c2 == 'u') {            // "push X"
                read(); read();         // 's','h'
                read();                 // space
                lastVal = readInt();    // X
                return 0;
            } else {                    // "pop"
                // 나머지 글자 소거
                while ((c = read()) > 32);
                return 1;
            }
        } else if (c == 's') {          // "size"
            while ((c = read()) > 32);
            return 2;
        } else if (c == 'e') {          // "empty"
            while ((c = read()) > 32);
            return 3;
        } else if (c == 'f') {          // "front"
            while ((c = read()) > 32);
            return 4;
        } else {                        // 'b' -> "back"
            while ((c = read()) > 32);
            return 5;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = readInt();

        int cap = n + 5;
        int[] q = new int[cap];
        int head = 0, tail = 0; // [head, tail) 구간에 요소 존재
        StringBuilder sb = new StringBuilder(Math.min(1 << 22, n * 3)); // 대략 버퍼 미리 확보

        for (int i = 0; i < n; i++) {
            int cmd = readCmd();
            if (cmd == 0) { // push
                q[tail] = lastVal;
                tail++; if (tail == cap) tail = 0;
            } else if (cmd == 1) { // pop
                if (head == tail) sb.append(-1).append('\n');
                else {
                    sb.append(q[head]).append('\n');
                    head++; if (head == cap) head = 0;
                }
            } else if (cmd == 2) { // size
                int size = tail - head;
                if (size < 0) size += cap;
                sb.append(size).append('\n');
            } else if (cmd == 3) { // empty
                sb.append(head == tail ? 1 : 0).append('\n');
            } else if (cmd == 4) { // front
                sb.append(head == tail ? -1 : q[head]).append('\n');
            } else { // back
                if (head == tail) sb.append(-1).append('\n');
                else {
                    int idx = tail - 1; if (idx < 0) idx += cap;
                    sb.append(q[idx]).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
