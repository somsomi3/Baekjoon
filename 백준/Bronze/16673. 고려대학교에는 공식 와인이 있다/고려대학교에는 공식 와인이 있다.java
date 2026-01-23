import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());//년수
		int K = Integer.parseInt(st.nextToken());//애착정도
		int P = Integer.parseInt(st.nextToken());//구매중독
		
		int ans =0;
		for(int i=0; i<=C; i++) {
			int x = i*(K+P*i);
			ans+=x;
		}	
		System.out.println(ans);
	}
}
