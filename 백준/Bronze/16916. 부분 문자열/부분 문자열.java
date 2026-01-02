import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int[] lps = buildLPS(t);

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (j == t.length()) {
                    System.out.println(1);
                    return;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        System.out.println(0);
    }

    static int[] buildLPS(String p) {
        int[] lps = new int[p.length()];
        int len = 0;
        int i = 1;

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
