import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
            double X = Double.parseDouble(br.readLine());
			//double A = X*8/10;
            double A = X * 0.8;
			System.out.printf("$%.2f\n",A);
		}
		
	}
}
