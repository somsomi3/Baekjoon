import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int candy = Integer.parseInt(st.nextToken());
			int nanugi = Integer.parseInt(st.nextToken());
			
			//나누기 몫 변수명? 나머지 변수명?
			int x = candy/nanugi;
			int y = candy%nanugi;
			
			System.out.println("You get "+x+" piece(s) and your dad gets "+y+" piece(s).");
		}
	}
}
