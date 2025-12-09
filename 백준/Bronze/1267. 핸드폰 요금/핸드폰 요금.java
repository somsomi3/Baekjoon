import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ysum =0;
		int msum =0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			int call = Integer.parseInt(st.nextToken());
			
			int young = 10*(call/30+1);
			ysum+= young;
			
			int min = 15*(call/60+1);
			msum+= min;
		}
//		System.out.println(ysum);
//		System.out.println(msum);
		int x = Math.min(ysum, msum);
		StringBuilder sb = new StringBuilder();
		if(ysum<msum) {
			sb.append("Y");
		}else if (msum<ysum) {
			sb.append("M");
		}else {
			sb.append("Y M");
		}
		sb.append(" ").append(x);
		System.out.println(sb);
	}
}