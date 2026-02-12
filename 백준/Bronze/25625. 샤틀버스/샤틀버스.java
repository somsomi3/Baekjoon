import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		if (x > y)ans = x + y;
		else if (x < y)ans = y - x;
		else ans = x;
		
		System.out.println(ans);
	}
}
