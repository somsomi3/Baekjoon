import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            int[][] arr = new int[k + 1][n + 1];
            
            for (int i = 1; i <= n; i++) arr[0][i] = i;
            
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
            
            sb.append(arr[k][n]).append('\n');
        }
        
        System.out.print(sb);
    }
}
