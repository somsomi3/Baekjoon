import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];
        int top = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                stack[top++] = x;
            } else {
                top--;
            }
        }

        long sum = 0;
        for (int i = 0; i < top; i++) {
            sum += stack[i];
        }

        System.out.println(sum);
    }
}
