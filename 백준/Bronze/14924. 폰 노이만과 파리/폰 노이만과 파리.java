import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int x = D/(S*2)*T;
		
		System.out.println(x);
		
	}
}
