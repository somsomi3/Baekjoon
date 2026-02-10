import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		int[] brr = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		int aCnt = 0;
		int bCnt = 0;
		
		String ma = "D";
		
		for(int i = 0; i < 10; i++) {
			if(arr[i]>brr[i]) {
				aCnt+=3;
				ma = "A";
			}
			else if(brr[i]>arr[i]) {
				bCnt+=3;
				ma = "B";
			}
			else {
				aCnt++;
				bCnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(aCnt).append(" ").append(bCnt).append("\n");
		if(aCnt>bCnt)sb.append("A");
		else if(bCnt>aCnt)sb.append("B");
		else if(bCnt==aCnt) {
			//안되면=모두무승부
			if(ma.equals("D"))sb.append("D");
			//제일 마지막에 이긴것
			else sb.append(ma);
		}
		
		System.out.println(sb);
	}
}