import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st.nextToken());
            int cnt = 0;
            
            int na = x % (A+B);
            if(na == 0) na = A+B;
            if(na <= A) cnt++;
            
            int na2 = x % (C+D);
            if(na2 == 0) na2 = C+D;
            if(na2 <= C) cnt++;
            
            System.out.println(cnt);
        }
    }
}