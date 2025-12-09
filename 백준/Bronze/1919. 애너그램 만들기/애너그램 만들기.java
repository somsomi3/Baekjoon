import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[26];

        String s = br.readLine();
        String t = br.readLine();

        for (char c : s.toCharArray()) cnt[c - 'a']++;
        for (char c : t.toCharArray()) cnt[c - 'a']--;

        int answer = 0;
        for (int i = 0; i < 26; i++)
            answer += Math.abs(cnt[i]);

        System.out.println(answer);
    }

}
