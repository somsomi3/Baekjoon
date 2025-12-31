import java.io.*;
import java.util.*;

public class Main {
	static int getGet(int t, int[] Line, int[] Score) {
		if(t==0)return 0;
		for(int i =0; i<Line.length; i++) {
			if(t<=Line[i]) {
				return Score[i];
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] aLine = {1, 3, 6, 10, 15, 21};
		int[] aScore = {500, 300, 200, 50, 30, 10};
		
		int[] bLine = {1, 3, 7, 15, 31};
		int[] bScore = {512, 256, 128, 64, 32};
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int total = getGet(a, aLine, aScore)+ getGet(b, bLine, bScore);
			
            System.out.println(total * 10000);
		}
   }
}
