import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean ok = true;

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        ok = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) ok = false;

            sb.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }
}
