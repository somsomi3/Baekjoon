import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			String s = br.readLine();			
//			String[] arr = s.split(" ");
            String[] arr = br.readLine().split(" ");

            //인덱스 0
            double x = Double.parseDouble(arr[0]);

            //인덱스 1~ 그이후의 것들
			for(int i =1; i<arr.length; i++) {
//				x = Integer.parseInt(arr[0]);
//				if(arr[i].charAt(i)=='@') {
				
				//charAt(0)이다.
				if(arr[i].charAt(0)=='@') {
					x*=3;
				}else if(arr[i].charAt(0)=='%') {
					x+=5;
				}else {
					x-=7;
				}
			}
//			System.out.println(x);
            System.out.printf("%.2f%n", x);
		}
		
	}
}