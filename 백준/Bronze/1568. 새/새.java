import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int k =1;
		int cnt =0;
		while(N>0) {
			if(N<k) {
				k=1;
			}
			N-=k;
			cnt++;
			k++;
		}
		System.out.println(cnt);
	}
}
