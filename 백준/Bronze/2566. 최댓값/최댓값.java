import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//완탐? 내가생각하는 완탐이란..
		
		int[][] arr = new int[9][9];
		int max = -1;
		int a = -1;
		int b = -1;
		for(int i =0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
				if(arr[i][j]==max) {
					a = i+1;
					b = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(a+" "+b);
	}
}