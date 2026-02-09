import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;	
		int[][] graph = new int[8][8];
		
		for(int i=0; i<8; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				graph[i][j] = line.charAt(j);
				if(((i%2==0&&j%2==0)||(i%2!=0&&j%2!=0))&&graph[i][j]=='F') {
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
		
	}
}
