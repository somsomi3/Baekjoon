import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double R = Double.parseDouble(br.readLine());

        System.out.println(Math.PI * R * R);
        System.out.println(2 * R * R);
    }
}
