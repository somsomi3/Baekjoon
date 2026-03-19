import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long mom = Long.parseLong(st.nextToken());
        long son = Long.parseLong(st.nextToken());
        
        long x = (son * 100) / mom;
        
        if(x >= 99) {
            System.out.println(-1);
            return;
        }
        
        long left = 1;
        long right = 1_000_000_000;
        long ans = -1;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long newX = ((son + mid) * 100) / (mom + mid);
            
            if(newX > x) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}