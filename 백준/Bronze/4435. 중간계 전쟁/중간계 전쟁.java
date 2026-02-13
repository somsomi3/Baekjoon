import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        int[] goodS = {1, 2, 3, 3, 4, 10};
        int[] evilS = {1, 2, 2, 2, 3, 5, 10};
        
        for (int x = 1; x <= T; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sumA = 0;
            
            for (int i = 0; i < 6; i++) {
                sumA += Integer.parseInt(st.nextToken()) * goodS[i];
            }
            
            st = new StringTokenizer(br.readLine());
            int sumB = 0;
            
            for (int i = 0; i < 7; i++) {
                sumB += Integer.parseInt(st.nextToken()) * evilS[i];
            }
            
            sb.append("Battle ").append(x).append(": ");
            
            if (sumA > sumB) {
                sb.append("Good triumphs over Evil");
            } else if (sumA < sumB) {
                sb.append("Evil eradicates all trace of Good");
            } else {
                sb.append("No victor on this battle field");
            }
            sb.append("\n");
        }        
        System.out.print(sb);
    }
}