
import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] parent = new int[10000];  // 경로 추적용
    static char[] how = new char[10000];   // 명령 기록
    static int[] visited = new int[10000]; // 방문 체크용 (타임스탬프 방식)
    static int visitId = 1; // 테스트케이스별로 증가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            bfs(start, target);

            // 경로 복원
            StringBuilder cmd = new StringBuilder();
            for (int cur = target; cur != start; cur = parent[cur]) {
                cmd.append(how[cur]);
            }
            output.append(cmd.reverse()).append("\n");
            visitId++; // 다음 테스트 케이스로 넘어가면 방문배열 초기화 없이 새 ID 사용
        }
        System.out.print(output);
    }

    static void bfs(int start, int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = visitId;

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == target) return;

            // D
            int d = (num * 2) % 10000;
            if (visited[d] != visitId) {
                visited[d] = visitId;
                parent[d] = num;
                how[d] = 'D';
                q.offer(d);
            }

            // S
            int s = (num == 0) ? 9999 : num - 1;
            if (visited[s] != visitId) {
                visited[s] = visitId;
                parent[s] = num;
                how[s] = 'S';
                q.offer(s);
            }

            // L
            int l = (num % 1000) * 10 + (num / 1000);
            if (visited[l] != visitId) {
                visited[l] = visitId;
                parent[l] = num;
                how[l] = 'L';
                q.offer(l);
            }

            // R
            int r = (num % 10) * 1000 + (num / 10);
            if (visited[r] != visitId) {
                visited[r] = visitId;
                parent[r] = num;
                how[r] = 'R';
                q.offer(r);
            }
        }
    }
}
