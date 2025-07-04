import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(countHan(N));
    }

    static int countHan(int N) {
        if (N < 100) return N;

        int count = 99;

        for (int i = 100; i <= N; i++) {
            if (isHan(i)) count++;
        }

        return count;
    }

    static boolean isHan(int num) {
        String s = Integer.toString(num);
        int len = s.length();
        int[] digits = new int[len];

        // 숫자를 각 자리 배열에 저장
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        int diff = digits[1] - digits[0];

        // 인접 자리 차이가 모두 같아야 함
        for (int i = 1; i < len - 1; i++) {
            if (digits[i + 1] - digits[i] != diff) {
                return false;
            }
        }

        return true;
    }
}
