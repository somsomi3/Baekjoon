import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        StringBuilder sb = new StringBuilder();
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[r+1][c+1];
        int[][] ps = new int[r+1][c+1];
        
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ps[i][j] = map[i][j]
                         + ps[i-1][j]
                         + ps[i][j-1]
                         - ps[i-1][j-1];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int sum = ps[x2][y2]
                    - ps[x1-1][y2]
                    - ps[x2][y1-1]
                    + ps[x1-1][y1-1];
            
            int cnt = (x2 - x1 + 1) * (y2 - y1 + 1);
            sb.append(sum / cnt).append('\n');
        }
        System.out.print(sb);
    }
}