import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int side = (int)Math.pow(2, n) + 1; 
        int answer = side * side;

        System.out.println(answer);
    }
}
