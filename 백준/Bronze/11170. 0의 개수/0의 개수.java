import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] parts = br.readLine().split(" ");
            int N = Integer.parseInt(parts[0]);
            int M = Integer.parseInt(parts[1]);

            int count = 0;

            for (int j = N; j <= M; j++) {
                int x = j;

                if (x == 0) {
                    count++;
                    continue;
                }

                while (x > 0) {
                    if (x % 10 == 0) count++;
                    x /= 10;
                }
            }

            out.append(count).append('\n');
        }

        System.out.print(out.toString());
    }
}
