import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String target = "UCPC";
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (idx < 4 && s.charAt(i) == target.charAt(idx)) {
                idx++;
            }
        }

        System.out.println(idx == 4 ? "I love UCPC" : "I hate UCPC");
    }
}
