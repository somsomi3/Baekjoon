import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) % 10;
            int b = Integer.parseInt(st.nextToken());
            
            if (a == 0) {
                System.out.println(10);
                continue;
            }
            
            int cycle = b % 4;
            if (cycle == 0) cycle = 4;
            
            int result = 1;
            for (int i = 0; i < cycle; i++) {
                result = (result * a) % 10;
            }
            
            System.out.println(result);
        }
    }
}