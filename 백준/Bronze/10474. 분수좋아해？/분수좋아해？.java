import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0 0"))break;
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(s);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(x/y).append(" ").append(x%y).append(" / ").append(y);
			System.out.println(sb);
		}
		
	}
}
