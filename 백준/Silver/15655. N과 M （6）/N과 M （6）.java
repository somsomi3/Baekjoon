import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0);
    }

    static void dfs(int depth, int start){

        if(depth == M){
            for(int i = 0; i < M; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < N; i++){
            ans[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}