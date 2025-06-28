import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] paper = new boolean[100][100];

        int n = Integer.parseInt(br.readLine());

        // 색종이 붙이기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int dx = x; dx < x + 10; dx++) {
                for (int dy = y; dy < y + 10; dy++) {
                    paper[dx][dy] = true;
                }
            }
        }

        // 넓이 계산
        int blackArea = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) blackArea++;
            }
        }

        System.out.println(blackArea);
    }
}
