import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            if (s ==1) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (s ==2) {
                sb.append(stack.isEmpty()? -1:stack.pop()).append('\n');
            } else if (s ==3) {
                sb.append(stack.size()).append('\n');
            } else if (s ==4) {
                sb.append(stack.isEmpty()? 1:0).append('\n');
            } else if (s ==5) {
                sb.append(stack.isEmpty()? -1:stack.peek()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
