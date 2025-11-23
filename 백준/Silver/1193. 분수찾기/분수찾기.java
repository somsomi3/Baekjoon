import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int line = 1;
        int sum = 0;

        while (sum + line < X) {
            sum += line;
            line++;
        }

        int pos = X - sum;
        int num, den;

        if (line % 2 == 0) {
            num = pos;
            den = line - pos + 1;
        } else {
            num = line - pos + 1;
            den = pos;
        }

        System.out.println(num + "/" + den);
    }
}
