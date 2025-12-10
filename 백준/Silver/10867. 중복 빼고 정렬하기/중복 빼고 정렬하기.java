import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 범위: -1000 ~ 1000 → 총 2001개
        boolean[] exist = new boolean[2001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            exist[num + 1000] = true; // index shift
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2001; i++) {
            if (exist[i]) sb.append(i - 1000).append(" ");
        }

        System.out.println(sb.toString());
    }
}
