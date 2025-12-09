import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int count = 0;
        int i = 0;

        while (i + t.length() <= s.length()) {
            if (s.substring(i, i + t.length()).equals(t)) {
                count++;
                i += t.length();  // 겹치지 않게
            } else {
                i++;  // 다음 문자로 이동
            }
        }

        System.out.println(count);
    }
}