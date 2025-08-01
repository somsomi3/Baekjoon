import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            // 열린 괄호는 무조건 스택에 push
            if (cur == '(') {
                stack.push(cur);
            } else { // 닫는 괄호 ')'인 경우
                stack.pop(); // 일단 하나 pop해서 대응되는 '(' 제거

                if (input.charAt(i - 1) == '(') {
                    // 바로 앞이 '('라면 → 레이저!
                    // 현재 열린 막대기 수만큼 잘리므로 조각 수 += 스택 크기
                    result += stack.size();
                } else {
                    // 막대기 끝 → 조각 1개 추가
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
