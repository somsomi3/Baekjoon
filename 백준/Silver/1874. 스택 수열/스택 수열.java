import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cur = 1; // 현재 push할 숫자
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // target까지 push
            while (cur <= target) {
                stack.push(cur++);
                sb.append("+\n");
            }

            // 스택의 top이 target과 같다면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 만들 수 없는 수열
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
