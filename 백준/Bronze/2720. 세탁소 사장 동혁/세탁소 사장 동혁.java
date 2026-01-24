import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int cntQ = 0;
			int cntD = 0;
			int cntN = 0;
			int cntP = 0;
			
			if(N>=25) {
				cntQ += N/25;
				N%=25;
			}if(N>=10) {
				cntD += N/10;
				N%=10;
			}if(N>=5) {
				cntN += N/5;
				N%=5;
			}if(N>=1) {
				cntP += N/1;
				N%=1;
			}
			
			System.out.println(cntQ+" "+cntD+" "+cntN+" "+cntP);
		}
	}
}
