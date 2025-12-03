import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int c0 = 0;
        int c1 = 0;

        char prev = s.charAt(0);
        if (prev == '0') c0++;
        else c1++;

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != prev) {
                if (cur == '0') c0++;
                else c1++;
                prev = cur;
            }
        }

        System.out.println(Math.min(c0, c1));
    }
}
