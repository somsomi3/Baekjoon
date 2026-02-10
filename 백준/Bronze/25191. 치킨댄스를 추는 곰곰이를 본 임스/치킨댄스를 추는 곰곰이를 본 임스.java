import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int chicken = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cola = Integer.parseInt(st.nextToken());
		int beer = Integer.parseInt(st.nextToken());
		
		int ans = Math.min(cola/2+beer, chicken);
		
		System.out.println(ans);
		
	}
}
