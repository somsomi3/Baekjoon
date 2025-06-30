import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int before = -1;
        for (int i = start; i < N; i++) {
            if (before != arr[i]) { // 중복 방지
                selected[depth] = arr[i];
                before = arr[i];
                dfs(depth + 1, i); // 중복 허용하므로 i부터 시작
            }
        }
    }
}
