import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		//누적합... 배열의 누적합 사용해 보자..
		
		int sum =0;
		if(x>1) {
			for(int i =0; i<x-1; i++) {// 1월은 합계가 제외다.
				sum += arr[i];
			}
		}
		sum+= y;
		
		int yoil = sum%7;
		
		if(yoil==0)System.out.println("SUN");
		else if(yoil==1)System.out.println("MON");
		else if(yoil==2)System.out.println("TUE");
		else if(yoil==3)System.out.println("WED");
		else if(yoil==4)System.out.println("THU");
		else if(yoil==5)System.out.println("FRI");
		else if(yoil==6)System.out.println("SAT");
	}
}