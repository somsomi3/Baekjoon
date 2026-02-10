import java.io.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        // 전체를 별로 채워두고
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = '*';
            }
        }

        // 재귀 시작
        dfs(0, 0, N);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y, int n) {
        // 종료 조건
        if (n == 1) return;

        int size = n / 3;

        // 가운데 블록을 공백으로 만들기
        for (int i = x + size; i < x + size * 2; i++) {
            for (int j = y + size; j < y + size * 2; j++) {
                map[i][j] = ' ';
            }
        }

        // 9칸 중 가운데 제외하고 재귀
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                if (dx == 1 && dy == 1) continue;
                dfs(x + dx * size, y + dy * size, size);
            }
        }
    }
}
