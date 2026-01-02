import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int ans =0;
		
		if(N%2==0) {
			ans = (N/2+1)*(N/2+1);
		}else {
			ans = ((N/2+1)+1)*(N/2+1);
		}
		
		System.out.println(ans);
	}
}
