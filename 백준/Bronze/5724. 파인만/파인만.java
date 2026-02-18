import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) break;

            int sum = x * (x + 1) * (2 * x + 1) / 6;
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}