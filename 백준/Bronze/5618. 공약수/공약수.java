import java.io.*;
import java.util.*;

public class Main {
	static int gcd(int a, int b) {
		while(b>0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int g= arr[0];
		for(int i =1; i<N; i++) {
			g = gcd(g, arr[i]);
		}
//		for(int j=1; j<=g; j++) {
//		if(g%j==0) {
//			System.out.println(j);
//			}
//		}
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i * i <= g; i++) {
		    if (g % i == 0) {
		        res.add(i);
		        if (i != g / i) {
		            res.add(g / i);
		        }
		    }
		}

		Collections.sort(res);
		for (int x : res) {
		    System.out.println(x);
		}
	}
}