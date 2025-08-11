import java.io.*;

public class Main {
    static final int BUF_SIZE = 1 << 16;
    static final byte SP = ' ';
    static final byte NL = '\n';
    static final byte CR = '\r';
    static byte[] buf = new byte[BUF_SIZE];
    static int idx = 0, size = 0;

    static int read() throws IOException {
        if (idx >= size) {
            size = System.in.read(buf);
            idx = 0;
            if (size <= 0) return -1;
        }
        return buf[idx++];
    }
    static int skip() throws IOException {
        int c;
        while ((c = read()) <= SP) {
            if (c == -1) return -1;
        }
        return c;
    }
    static int readInt() throws IOException {
        int c = skip();
        int sign = 1;
        if (c == '-') { sign = -1; c = read(); }
        int n = 0;
        while (c > SP) {
            n = n * 10 + (c - '0');
            c = read();
        }
        return n * sign;
    }
    // 명령어는 문자열 만들지 않고 첫/둘째 글자로 분기
    static int readCommand() throws IOException {
        int c = skip();          // 첫 글자
        if (c == 'p') {          // push or pop
            int d = read();      // 둘째 글자
            if (d == 'u') {      // push
                // 남은 sh 소모 + 공백까지 스킵
                while ((d = read()) > SP) {}
                return 1;        // code 1 = push
            } else {             // pop
                // 남은 p 소모
                while ((d = read()) > SP) {}
                return 2;        // code 2 = pop
            }
        } else if (c == 't') {   // top
            int d;
            while ((d = read()) > SP) {}
            return 3;
        } else if (c == 's') {   // size
            int d;
            while ((d = read()) > SP) {}
            return 4;
        } else if (c == 'e') {   // empty
            int d;
            while ((d = read()) > SP) {}
            return 5;
        }
        return -1; 
    }

    public static void main(String[] args) throws Exception {
        StringBuilder out = new StringBuilder(1 << 20);

        int N = readInt();
        int[] stack = new int[N]; // 명령 수만큼이면 충분
        int top = -1;

        for (int i = 0; i < N; i++) {
            int cmd = readCommand();
            if (cmd == 1) {                  // push
                int x = readInt();
                stack[++top] = x;
            } else if (cmd == 2) {           // pop
                out.append(top == -1 ? -1 : stack[top--]).append('\n');
            } else if (cmd == 3) {           // top
                out.append(top == -1 ? -1 : stack[top]).append('\n');
            } else if (cmd == 4) {           // size
                out.append(top + 1).append('\n');
            } else if (cmd == 5) {           // empty
                out.append(top == -1 ? 1 : 0).append('\n');
            }
        }
        System.out.print(out);
    }
}
