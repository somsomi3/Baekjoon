import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//카운트 배열까지는 생각했음.
		int[] count = new int[11];
		Arrays.fill(count, -1);

		int cnt =0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(count[a]==-1) {
				count[a]=b;	
			}else if(count[a]!=b) {
				count[a]=b;	
				cnt++;
			}else continue;
		}
		System.out.println(cnt);
	}
}
