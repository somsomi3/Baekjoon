import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();
        for (char c : str.toCharArray()) {
            left.push(c);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);

            if (cmd == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (cmd == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (cmd == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (cmd == 'P') {
                char ch = command.charAt(2);
                left.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
