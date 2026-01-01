import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    static void hanoi(int n, int from, int via, int to) {
        if (n == 0) return;

        hanoi(n - 1, from, to, via);
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        hanoi(n - 1, via, from, to);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(count);
        System.out.print(sb.toString());
    }
}
