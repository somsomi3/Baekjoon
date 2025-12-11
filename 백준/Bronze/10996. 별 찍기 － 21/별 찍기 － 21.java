import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 2 * N; i++) {
            if (i % 2 == 0) { // 홀수 번째 줄
                for(int j = 0; j < N; j++) {
                    if(j % 2 == 0) sb.append("*");
                    else sb.append(" ");
                }
            } else { // 짝수 번째 줄
                for(int j = 0; j < N; j++) {
                    if(j % 2 == 0) sb.append(" ");
                    else sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
