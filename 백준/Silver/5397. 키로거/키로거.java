import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();

            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();

            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(c); // 문자 입력
                }
            }

            StringBuilder sb = new StringBuilder();

            // 왼쪽 스택은 반대로 넣었으니 뒤집어서 출력
            while (!left.isEmpty()) {
                sb.append(left.removeLast());
            }

            while (!right.isEmpty()) {
                sb.append(right.removeFirst());
            }

            System.out.println(sb.toString());
        }
    }
}
