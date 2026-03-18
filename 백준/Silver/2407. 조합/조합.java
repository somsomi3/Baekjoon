import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		M = Math.min(M, N- M);
		
		BigInteger result = BigInteger.ONE;
		
		for(int i = 1; i <= M; i++){
            result = result.multiply(BigInteger.valueOf(N - i + 1));
            result = result.divide(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }
}