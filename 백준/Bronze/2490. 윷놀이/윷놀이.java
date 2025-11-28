import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] map = {'E', 'A', 'B', 'C', 'D'};

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zero = 0;

            for (int j = 0; j < 4; j++) {
                if (st.nextToken().charAt(0) == '0') zero++;
            }

            System.out.println(map[zero]);
        }
    }
}
