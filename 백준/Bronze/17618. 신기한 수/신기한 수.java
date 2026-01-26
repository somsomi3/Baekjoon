import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
        int cnt = 0;
		for(int i=1; i<=N; i++) {
			int x = i;
			int sum =0;
			while(x>0) {
			    sum += x % 10;
			    x /= 10;
			}
            if (i % sum == 0) cnt++;
		}
        System.out.println(cnt);
    }
}