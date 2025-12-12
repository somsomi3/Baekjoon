import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = br.readLine()) != null) {
            int so = 0, dae = 0, su = 0, gong = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == ' ') gong++;
                else if (c >= 'a' && c <= 'z') so++;
                else if (c >= 'A' && c <= 'Z') dae++;
                else if (c >= '0' && c <= '9') su++;
            }

            System.out.println(so + " " + dae + " " + su + " " + gong);
        }
    }
}