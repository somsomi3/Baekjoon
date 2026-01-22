import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int HP = Integer.parseInt(st.nextToken());
			int MP = Integer.parseInt(st.nextToken());
			int gong = Integer.parseInt(st.nextToken());
			int bang = Integer.parseInt(st.nextToken());
			
			int jHP = Integer.parseInt(st.nextToken());
			int jMP = Integer.parseInt(st.nextToken());
			int jGong = Integer.parseInt(st.nextToken());
			int jBang = Integer.parseInt(st.nextToken());
				
			int x = HP+jHP;
			int y = MP+jMP;
			int z = gong+jGong;
			//마지막에
			if(x<1)x=1;
			if(y<1)y=1;
			if(z<0)z =0;
			
			
			int ans = x*1+ y*5+ z*2+ (bang+jBang)*2;
			
			System.out.println(ans);
		}
		
	}
}