import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] q = new int[n + 5];
        int head = 0, tail = 0;
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String s = br.readLine();
            if (s.charAt(0) == 'p') { // push or pop
                if (s.charAt(1) == 'u') { // push X
                    int x = Integer.parseInt(s.substring(5));
                    q[tail++] = x;
                } else { // pop
                    sb.append(head == tail ? -1 : q[head++]).append('\n');
                }
            } else if (s.charAt(0) == 's') { // size
                sb.append(tail - head).append('\n');
            } else if (s.charAt(0) == 'e') { // empty
                sb.append(head == tail ? 1 : 0).append('\n');
            } else if (s.charAt(0) == 'f') { // front
                sb.append(head == tail ? -1 : q[head]).append('\n');
            } else { // back
                sb.append(head == tail ? -1 : q[tail - 1]).append('\n');
            }
        }
        System.out.print(sb);
    }
}
