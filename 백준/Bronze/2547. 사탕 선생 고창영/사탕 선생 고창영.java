import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			br.readLine();
			
			int N = Integer.parseInt(br.readLine());
			
			BigInteger sum = BigInteger.ZERO;
			
			for(int i = 0; i <N; i++) {
				BigInteger bigInteger = new BigInteger(br.readLine());
				
				sum = sum.add(bigInteger);
				
			}
			
			if (sum.mod(BigInteger.valueOf(N)).equals(BigInteger.ZERO)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}