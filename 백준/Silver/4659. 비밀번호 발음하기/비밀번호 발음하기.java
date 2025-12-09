import java.io.*;
import java.util.*;

public class Main {
    static boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s;
        while (!(s = br.readLine()).equals("end")) {
            
            boolean hasVowel = false;
            int vowelCnt = 0;
            int consCnt = 0;
            boolean ok = true;

            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                if (isVowel(c)) {
                    hasVowel = true;
                    vowelCnt++;
                    consCnt = 0;
                } else {
                    consCnt++;
                    vowelCnt = 0;
                }

                if (vowelCnt == 3 || consCnt == 3) ok = false;

                if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                    if (!(c=='e' || c=='o')) ok = false;
                }
            }

            if (ok && hasVowel) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
}
