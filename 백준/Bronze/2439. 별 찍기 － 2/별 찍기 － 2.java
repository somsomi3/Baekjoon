import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
            // 앞쪽 공백 (N - i)
            for(int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) {
            	System.out.print("*");
            }
			System.out.println(" ");
		}
	}
}