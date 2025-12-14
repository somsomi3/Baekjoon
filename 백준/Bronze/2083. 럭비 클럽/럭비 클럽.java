import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("# 0 0")) break;

            String[] arr = s.split(" ");
            String name = arr[0];
            int age = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);

            if (age > 17 || weight >= 80) {
                System.out.println(name + " Senior");
            } else {
                System.out.println(name + " Junior");
            }
        }
    }
}
