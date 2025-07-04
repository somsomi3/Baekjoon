import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // 입력값
        
        System.out.println(han(N));  // 결과 출력
    }

    public static int han(int N) {
        if (N < 100) {
            // 1~99는 모두 한수
            return N;
        }

        int count = 99; // 1~99는 모두 한수라서 기본 99로 시작

        for (int i = 100; i <= N; i++) {
            int hun = i / 100;          // 백의 자리
            int ten = (i / 10) % 10;    // 십의 자리
            int one = i % 10;           // 일의 자리

            if ((hun - ten) == (ten - one)) {
                // 등차수열 만족하면 한수!
                count++;
            }
        }

        return count;
    }
}
