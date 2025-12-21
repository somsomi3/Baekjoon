import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum =0;
		int nanugi =0;
		int[] count = new int[1001];
		
		for(int i =0; i<10; i++) {
			int x = Integer.parseInt(br.readLine());
			sum += x;
			nanugi++;
			count[x]++;
		}
		
		int mmax = 0;
		int answer =0;
		for(int i =0; i<count.length;i++) {
//			mmax = Math.max(mmax, count[i]);
			if(count[i]>mmax) {
				mmax =count[i];
				answer = i;
			}
		}
		
		System.out.println(sum/nanugi);
		System.out.println(answer);
		
	}
}
