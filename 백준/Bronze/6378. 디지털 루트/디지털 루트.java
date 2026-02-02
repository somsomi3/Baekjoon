import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            while (s.length() > 1) {
                int sum = 0;
                for (int i =0; i<s.length(); i++) {
                    sum += s.charAt(i)-'0';
                }
                s = String.valueOf(sum);
            }

            System.out.println(s);
        }
    }
}