class Solution {
    public int solution(String[][] board, int h, int w) {

        int cnt = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        String color = board[h][w];

        for (int i = 0; i < 4; i++) {

            int nr = h + dr[i];
            int nc = w + dc[i];

            if (nr < 0 || nr >= board.length ||
                nc < 0 || nc >= board[0].length) {
                continue;
            }

            if (board[nr][nc].equals(color)) {
                cnt++;
            }
        }
        return cnt;
    }
}