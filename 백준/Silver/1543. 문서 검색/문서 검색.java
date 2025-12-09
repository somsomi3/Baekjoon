import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        int sl = s.length();
        int tl = t.length();

        int count = 0;

        for (int i = 0; i <= sl - tl; ) {
            boolean match = true;

            for (int j = 0; j < tl; j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
                i += tl;     // 겹치면 안 되므로 t 길이만큼 점프
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
