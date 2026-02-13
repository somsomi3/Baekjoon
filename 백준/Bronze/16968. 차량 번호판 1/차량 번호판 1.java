import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int ans = 1;
        
        if (s.charAt(0) == 'c') ans *= 26;
        else ans *= 10;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'c') {
                if (s.charAt(i - 1) == 'c')
                    ans *= 25;
                else
                    ans *= 26;
            } else {
                if (s.charAt(i - 1) == 'd')
                    ans *= 9;
                else
                    ans *= 10;
            }
        }
        
        System.out.println(ans);
    }
}