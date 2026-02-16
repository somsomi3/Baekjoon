import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		
		int z = Math.min(X, Y);
		
		int a =0;
		if(z==X)a=B;
		else a=A;
		
		int one = A*X+B*Y;
		int two = C*z*2+a*(Math.abs(X-Y)); 
		int three = Math.max(X,Y)*2*C;
		
		int ans = Math.min(one, Math.min(two, three));
		
		System.out.println(ans);
	}
}