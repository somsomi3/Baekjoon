import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                if (!stack.isEmpty()) {
                    stack.pop(); // 최근 숫자 제거
                }
            } else {
                stack.push(num); // 스택에 추가
            }
        }

        int sum = 0;
        for (int n : stack) {
            sum += n; // 스택에 남아있는 수 모두 더하기
        }

        System.out.println(sum);
    }
}
