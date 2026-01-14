import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger big = new BigInteger(br.readLine());
		
        BigInteger TWO = BigInteger.valueOf(2);
		
		Stack<Integer> stack = new Stack<>();
		
		
		while(big.compareTo(BigInteger.ZERO) >0) {
			stack.push(big.mod(TWO).intValue());
            big = big.divide(TWO);
        }
		   StringBuilder sb = new StringBuilder();
	        while (!stack.isEmpty()) {
	            sb.append(stack.pop());
	        }

	        System.out.println(sb.toString());
	    }
	}