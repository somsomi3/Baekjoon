import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            int sum = 0;

            for (String s : arr) {
                sum += Integer.parseInt(s);
            }

            System.out.println(sum);
        }
    }
}