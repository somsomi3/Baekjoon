import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int x = N/H +1;
			
			int y = N%H;

            if (y == 0) {
                y = H;
                x = N / H;
            }
            
			String s;
			if(x<10) {
				s = "0"+x;
				
				System.out.print(y);
				System.out.println(s);
			}else {
				System.out.print(y);
				System.out.println(x);
			}
		}	
	}
}
