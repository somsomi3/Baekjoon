import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            char[][] arr = new char[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.next().toCharArray();
            }

            int sum = 0;

            for (int i = 0; i < N; i++) {

                int start, end;

                if (i <= N / 2) {
                    start = N / 2 - i;
                    end = N / 2 + i;
                } else {
                    int re = i - N / 2;
                    start = re;
                    end = N - 1 - re;
                }

                for (int j = start; j <= end; j++) {
                    sum += arr[i][j] - '0';
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}