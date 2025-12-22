import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] line;

    static void cant(int start, int len) {
        if (len == 1) return;

        int third = len / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            line[i] = ' ';
        }

        if (third > 1) {
            cant(start, third);
            cant(start + 2 * third, third);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int len = (int) Math.pow(3, N);

            line = new char[len];
            for (int i = 0; i < len; i++) {
                line[i] = '-';
            }

            cant(0, len);

            System.out.println(line);
        }
    }
}
