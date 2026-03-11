import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] l = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> line = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            line.add(l[i], i);
        }
        for (int x : line) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}