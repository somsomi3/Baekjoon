import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			String x = br.readLine();
			String ansans ="";
			String t =new StringBuilder(x).reverse().toString();
			
			int xx = Integer.parseInt(x);
			int yy = Integer.parseInt(t);
			
			int ans = xx+yy;
			ansans+=ans;
		
			boolean ok = true;
            int n = ansans.length();
            for (int i = 0; i < n / 2; i++) {
                if (ansans.charAt(i) != ansans.charAt(n - i - 1)) {
                    ok = false;
                    break;
                }
            }

            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}