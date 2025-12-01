import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) % 10; //마지막 숫자만 필요
            int b = Integer.parseInt(st.nextToken());

            int result = 0;
            switch (a) {
                case 0: result = 10; break;
                case 1: result = 1; break;
                case 5: result = 5; break;
                case 6: result = 6; break;

                case 2:
                    int[] c2 = {2, 4, 8, 6};
                    result = c2[(b - 1) % 4];
                    break;

                case 3:
                    int[] c3 = {3, 9, 7, 1};
                    result = c3[(b - 1) % 4];
                    break;

                case 7:
                    int[] c7 = {7, 9, 3, 1};
                    result = c7[(b - 1) % 4];
                    break;

                case 8:
                    int[] c8 = {8, 4, 2, 6};
                    result = c8[(b - 1) % 4];
                    break;

                case 4:
                    int[] c4 = {4, 6};
                    result = c4[(b - 1) % 2];
                    break;

                case 9:
                    int[] c9 = {9, 1};
                    result = c9[(b - 1) % 2];
                    break;
            }

            System.out.println(result);
        }
    }
}
