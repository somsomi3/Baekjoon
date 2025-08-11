import java.io.*;

public class Main {
    static final int BSZ = 1 << 16;
    static final byte[] buf = new byte[BSZ];
    static int bi = 0, bn = 0;
    static int read() throws IOException {
        if (bi >= bn) {
            bn = System.in.read(buf);
            bi = 0;
            if (bn < 0) return -1;
        }
        return buf[bi++];
    }
    static int readInt() throws IOException {
        int c, x = 0, sgn = 1;
        do { c = read(); } while (c <= 32);
        if (c == '-') { sgn = -1; c = read(); }
        while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
        return x * sgn;
    }

    public static void main(String[] args) throws Exception {
        int n = readInt();
        int[] st = new int[n];
        int top = 0;
        int next = 1;

        // 출력은 2N줄 확정 -> 각 줄 2문자(기호 + '\n') => 4N char
        char[] out = new char[4 * n];
        int oi = 0;

        for (int i = 0; i < n; i++) {
            int target = readInt();

            while (next <= target) {
                st[top++] = next++;
                out[oi++] = '+'; out[oi++] = '\n';
            }

            // top 확인
            if (top == 0 || st[top - 1] != target) {
                System.out.print("NO");
                return;
            }
            top--;
            out[oi++] = '-'; out[oi++] = '\n';
        }

        // 한 번에 출력
        OutputStreamWriter w = new OutputStreamWriter(System.out);
        w.write(out, 0, oi);
        w.flush();
    }
}
