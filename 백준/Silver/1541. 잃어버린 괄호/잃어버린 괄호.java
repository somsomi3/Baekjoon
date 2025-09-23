
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();

        // '-' 기준으로 나누기
        String[] parts = expr.split("-");

        int result = 0;

        // 첫 번째 그룹(맨 앞)은 무조건 더하기
        String[] first = parts[0].split("\\+");
        for (String num : first) {
            result += Integer.parseInt(num);
        }

        // 두 번째 그룹부터는 괄호로 묶인 효과 = 전부 빼기
        for (int i = 1; i < parts.length; i++) {
            String[] nums = parts[i].split("\\+");
            int sum = 0;
            for (String num : nums) {
                sum += Integer.parseInt(num);
            }
            result -= sum;
        }

        System.out.println(result);
    }
}
