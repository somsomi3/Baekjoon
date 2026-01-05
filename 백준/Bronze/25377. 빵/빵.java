import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
	
		int min = 1001;//여러 경우 모두를 따진다음 max를 가져와야해서 여기서 초기화.
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int iGo = Integer.parseInt(st.nextToken());
			int Bang = Integer.parseInt(st.nextToken());
			
			if(iGo<=Bang) {
				min = Math.min(min, Bang);
			}
		}
		System.out.println(min==1001? -1:min);
	}
}
