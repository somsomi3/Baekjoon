import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		for(int i =0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());		
		}
		long ans =0;
		
		long x = arr[1]- arr[0];
		long y = arr[2]- arr[1];
		
		long a = arr[1]/arr[0];
		long b = arr[2]/arr[1];
		
		if(x==y)ans = arr[N-1]+x;
		else if(a==b)ans = arr[N-1]*a;
		
		System.out.println(ans);
	}
}
