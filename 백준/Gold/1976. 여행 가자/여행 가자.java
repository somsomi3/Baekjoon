import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;  // 대표 노드 저장
    static int[][] map;   // 인접 행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        map = new int[N + 1][N + 1];

        // 대표 노드 초기화: 자기 자신이 대표
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 연결 정보 입력 & union 처리
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        int root = find(firstCity);  // 첫 도시 대표

        boolean possible = true;

        for (int i = 1; i < M; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (root != find(nextCity)) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    // find + path compression
    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  // 경로 압축
        }
        return parent[x];
    }

    // union
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[py] = px;  // 하나의 루트에 합침
        }
    }
}
