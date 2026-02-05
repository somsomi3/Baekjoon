import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int aa = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int ans = 0;
		while (x != y) {
		    x = (x + 1)/2;
		    y = (y + 1)/2;
		    ans++;
		}
		System.out.println(ans);
	}
}
