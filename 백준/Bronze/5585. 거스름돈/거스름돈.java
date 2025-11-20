import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int x = 1000-N;
//		System.out.println(x);
		int count = 0;
		while(x >0) {
			if(x>=500) {
				x -= 500;
				count++;
//				System.out.println(x);
			}else if(x>=100) {
				x -= 100;
				count++;
//				System.out.println(x);
			}else if(x>=50) {
				x -= 50;
				count++;
//				System.out.println(x);
			}else if(x>=10) {
				x -= 10;
				count++;
//				System.out.println(x);
			}else if(x>=5) {
				x -= 5;
				count++;
//				System.out.println(x);
			}else if(x>=1) {
				x -= 1;
				count++;
//				System.out.println(x);
			}
		}
		System.out.println(count);
	}
}
