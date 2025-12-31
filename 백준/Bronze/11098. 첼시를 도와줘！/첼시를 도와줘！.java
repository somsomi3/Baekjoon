import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			
			long[] cList = new long[n];
			String[] cName = new String[n];
			
			long x = 0;
			//c값이 long이다.
			String answer = "";
			
			for(int i =0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				cList[i] = Long.parseLong(st.nextToken());
				cName[i] = st.nextToken();
				
//				x = Math.max(x, cList[i]);
				if(cList[i]>x) {
					x = cList[i];
					answer = cName[i];
				}
			}
			System.out.println(answer);
		}	
	}
}
