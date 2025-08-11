import java.io.*;
import java.util.*;

public class Main {
    static int readInt() throws IOException {
        int c, n = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= ' ') ; // 공백/개행 스킵
        if (c == '-') { neg = true; c = System.in.read(); }
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) >= '0' && c <= '9');
        return neg ? -n : n;
    }

    static String readWord() throws IOException {
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = System.in.read()) <= ' ') ; // 공백/개행 스킵
        do {
            sb.append((char)c);
        } while ((c = System.in.read()) > ' ');
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        StringBuilder out = new StringBuilder();
        int N = readInt();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String cmd = readWord();

            if (cmd.equals("push")) {
                stack.push(readInt());
            } else if (cmd.equals("pop")) {
                out.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            } else if (cmd.equals("size")) {
                out.append(stack.size()).append('\n');
            } else if (cmd.equals("empty")) {
                out.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("top")) {
                out.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }
        System.out.print(out);
    }
}
