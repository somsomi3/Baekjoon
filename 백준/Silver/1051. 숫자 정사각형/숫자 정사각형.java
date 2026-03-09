import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int result = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

                for(int k = 1; i + k < N && j + k < M; k++) {

                    if(arr[i][j] == arr[i][j+k] &&
                       arr[i][j] == arr[i+k][j] &&
                       arr[i][j] == arr[i+k][j+k]) {

                    	result = Math.max(result, (k+1)*(k+1));
                    }
                }
            }
        }
        System.out.println(result);
    }
}