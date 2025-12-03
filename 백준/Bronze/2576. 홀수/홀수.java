import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =7;
		
		int min =101;
		int sum= 0;
		for(int i =0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x%2!=0) {
				sum+=x;
				if (x<min)min=x;
			}

		}
		if(sum==0)System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}