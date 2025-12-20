import java.io.*;
import java.util.*;

public class Main {

    static int digitSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();

            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if (sumA != sumB)
                return sumA - sumB;

            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
