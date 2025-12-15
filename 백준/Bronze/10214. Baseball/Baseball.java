import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int moduSum = 0;
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			for(int i=0; i<9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int Y = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				
				moduSum +=Y;
				moduSum -= K;
			}
			
			if(moduSum>0) {
				System.out.println("Yonsei");
			}else if(moduSum<0) {
				System.out.println("Korea");
			}else {
				System.out.println("Draw");
			}
		}
		
	}			
}
