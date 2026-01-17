import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			int x = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<x; i++) {
				for(int j=0; j<x; j++) {
					if(i!=0&&j!=0&&i!=x-1&&j!=x-1) {
						sb.append("J");
					}
					else sb.append("#");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
		}
	}
}
