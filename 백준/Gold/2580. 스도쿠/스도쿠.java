import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static int[] row = new int[9];
    static int[] col = new int[9];
    static int[] box = new int[9];
    static List<int[]> blanks = new ArrayList<>();

    static final int FULL = (1 << 10) - 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;

                if (val == 0) {
                    blanks.add(new int[]{i, j});
                } else {
                    int bit = 1 << val;
                    row[i] |= bit;
                    col[j] |= bit;
                    box[getBox(i, j)] |= bit;
                }
            }
        }

        dfs(0);
    }

    static void dfs(int idx) {
        if (idx == blanks.size()) {
            printBoard();
            System.exit(0);
        }

        int y = blanks.get(idx)[0];
        int x = blanks.get(idx)[1];
        int b = getBox(y, x);

        int used = row[y] | col[x] | box[b];
        int canUse = ~used & FULL;

        for (int num = 1; num <= 9; num++) {
            int bit = 1 << num;
            if ((canUse & bit) != 0) {
                board[y][x] = num;
                row[y] |= bit;
                col[x] |= bit;
                box[b] |= bit;

                dfs(idx + 1);

                board[y][x] = 0;
                row[y] ^= bit;
                col[x] ^= bit;
                box[b] ^= bit;
            }
        }
    }

    static int getBox(int y, int x) {
        return (y / 3) * 3 + (x / 3);
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int val : row) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
