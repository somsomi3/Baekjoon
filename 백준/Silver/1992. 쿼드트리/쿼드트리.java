import java.io.*;

public class Main {

    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    static void quad(int x, int y, int size) {
        char first = map[x][y];
        boolean same = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            sb.append(first);
            return;
        }

        int half = size / 2;
        sb.append('(');
        quad(x, y, half);
        quad(x, y + half, half);
        quad(x + half, y, half);
        quad(x + half, y + half, half);
        sb.append(')');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        quad(0, 0, N);
        System.out.println(sb.toString());
    }
}
