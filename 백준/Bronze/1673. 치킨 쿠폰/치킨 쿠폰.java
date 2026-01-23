import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
//		while(!(s =br.readLine()).isEmpty()) {
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int ans = N;
			while(N>=K) {//K일때까지만 나눌수 있고
				ans+= N/K;
				N= N/K+ N%K;//나머지도 모아서 될수도 있다.
			}
			
			System.out.println(ans);
		}
		
	}
}
