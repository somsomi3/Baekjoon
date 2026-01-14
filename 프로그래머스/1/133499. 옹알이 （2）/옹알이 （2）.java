import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] babbling) {

        int N = babbling.length;
        int result = 0;

        for (int i = 0; i < N; i++) {
            String x = babbling[i];
            int n = x.length();
            boolean flag = true;

            int j = 0;
            String prev = "";

            while (j < n) {
                if (j + 2 < n && x.charAt(j) == 'a' && x.charAt(j + 1) == 'y' && x.charAt(j + 2) == 'a') {
                    if (prev.equals("aya")) {
                        flag = false;
                        break;
                    }
                    prev = "aya";
                    j += 3;

                } else if (j + 1 < n && x.charAt(j) == 'y' && x.charAt(j + 1) == 'e') {
                    if (prev.equals("ye")) {
                        flag = false;
                        break;
                    }
                    prev = "ye";
                    j += 2;

                } else if (j + 2 < n && x.charAt(j) == 'w' && x.charAt(j + 1) == 'o' && x.charAt(j + 2) == 'o') {
                    if (prev.equals("woo")) {
                        flag = false;
                        break;
                    }
                    prev = "woo";
                    j += 3;

                } else if (j + 1 < n && x.charAt(j) == 'm' && x.charAt(j + 1) == 'a') {
                    if (prev.equals("ma")) {
                        flag = false;
                        break;
                    }
                    prev = "ma";
                    j += 2;

                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) result++;
        }

        return result;
    }
}
