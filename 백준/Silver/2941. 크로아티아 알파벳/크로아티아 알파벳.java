import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == 'c' && i + 1 < len) {
                if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                    count++;
                    i++;
                    continue;
                }
            }

            if (c == 'd' && i + 1 < len) {
                if (s.charAt(i + 1) == 'z' && i + 2 < len && s.charAt(i + 2) == '=') {
                    count++;
                    i += 2;
                    continue;
                } else if (s.charAt(i + 1) == '-') {
                    count++;
                    i++;
                    continue;
                }
            }

            if ((c == 'l' || c == 'n') && i + 1 < len) {
                if (s.charAt(i + 1) == 'j') {
                    count++;
                    i++;
                    continue;
                }
            }

            if ((c == 's' || c == 'z') && i + 1 < len) {
                if (s.charAt(i + 1) == '=') {
                    count++;
                    i++;
                    continue;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}