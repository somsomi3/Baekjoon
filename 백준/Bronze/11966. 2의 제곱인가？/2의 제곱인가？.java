import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N > 0 && (N & (N - 1)) == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
