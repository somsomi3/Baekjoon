import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		double[] pay = {350.34, 230.90, 190.55, 125.30, 180.90};
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			double aSum = a*pay[0];
			double bSum = b*pay[1];			
			double cSum = c*pay[2];
			double dSum = d*pay[3];
			double eSum = e*pay[4];
			
			double sum = aSum+ bSum+ cSum+ dSum + eSum;
			
			System.out.printf("$%.2f\n", sum);
		}
		
	}
}
