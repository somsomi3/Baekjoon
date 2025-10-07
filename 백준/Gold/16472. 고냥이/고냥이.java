import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] count = new int[26];
        int left = 0, right = 0;
        int distinct = 0;
        int maxLen = 0;

        while (right < s.length()) {
            int r = s.charAt(right) - 'a';
            
            // 새 문자라면 종류 +1
            if (count[r] == 0) distinct++;
            count[r]++;
            right++;

            // 종류가 N 초과되면 왼쪽 줄이기
            if (distinct > N) {
                int l = s.charAt(left) - 'a';
                count[l]--;
                if (count[l] == 0) distinct--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        System.out.println(maxLen);
    }
}
