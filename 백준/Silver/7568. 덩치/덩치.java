import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); // weight
            arr[i][1] = sc.nextInt(); // height
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    cnt++;
                }
            }
            rank[i] = cnt + 1;
        }

        for (int r : rank) {
            System.out.print(r + " ");
        }
    }
}
