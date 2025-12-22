import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int white = 0; // 흰색 종이 수
    static int blue = 0;  // 파란색 종이 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N); // (0,0)부터 시작, 크기 N

        System.out.println(white);
        System.out.println(blue);
    }

    // 분할정복 함수
    static void divide(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        divide(x, y, newSize);                     // 1사분면
        divide(x, y + newSize, newSize);           // 2사분면
        divide(x + newSize, y, newSize);           // 3사분면
        divide(x + newSize, y + newSize, newSize); // 4사분면
    }

    // 같은 색인지 확인
    static boolean checkColor(int x, int y, int size) {
        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true;
    }
}
