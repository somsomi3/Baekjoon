import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int sum= 0;
			int s = Integer.parseInt(br.readLine());
			sum+=s;
			int n = Integer.parseInt(br.readLine());

			for(int i =0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				int x = p*q;
				sum+=x;
			}
			System.out.println(sum);
		}
	}
}
