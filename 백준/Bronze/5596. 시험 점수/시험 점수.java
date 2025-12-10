import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[4];
		int asum = 0;
		int[] brr = new int[4];
		int bsum =0;
		
		for(int i =0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			asum+= arr[i];
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<4; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
			bsum+= brr[i];
		}
		
		int x = Math.max(asum, bsum);
		
		if(asum==bsum)System.out.println(asum);
		else System.out.println(x);
		
	}
}
