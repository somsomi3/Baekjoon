import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 인접 행렬 입력 받으면서 union
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 확인
        // 시작을 고정해서 시작이랑만 비교하자.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());

        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(first) != find(next)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

}
