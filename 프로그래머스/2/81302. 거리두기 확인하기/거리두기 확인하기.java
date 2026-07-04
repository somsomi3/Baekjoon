import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {

            answer[i] = 1;

            for (int j = 0; j < 5; j++) {

                for (int k = 0; k < 5; k++) {

                    if (places[i][j].charAt(k) == 'P') {

                        if (!bfs(places[i], j, k)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }

                if (answer[i] == 0) break;
            }
        }

        return answer;
    }

    public boolean bfs(String[] place, int x, int y) {

        boolean[][] visited = new boolean[5][5];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            int cx = now[0];
            int cy = now[1];
            int dist = now[2];

            if (dist == 2) continue;

            for (int d = 0; d < 4; d++) {

                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (place[nx].charAt(ny) == 'X')
                    continue;

                if (place[nx].charAt(ny) == 'P')
                    return false;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return true;
    }
}