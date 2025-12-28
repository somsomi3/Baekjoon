import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
		
		long x = Math.max(N, M);
		long y = Math.min(N, M);
		
		if(1<=y&& 2<=x) {
			System.out.println(x*y/2);
        } else {
            System.out.println(0);
        }
	}
}
