import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int a = 1;

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() == a) {
                stack.pop();
                a++;
            }

            if (cur == a) {
                a++;
            } else {
                stack.push(cur);
            }
        }

        while (!stack.isEmpty() && stack.peek() == a) {
            stack.pop();
            a++;
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
