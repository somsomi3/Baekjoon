import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		//마시고 나온 빈 병도 다시 계산에 포함된다
		int empty = e + f;
		int ans = 0;
		while (empty >= c) {
			int drink = empty / c;
		    ans += drink;
		    empty = drink + (empty % c);
		}

		System.out.println(ans);
		
	}
}