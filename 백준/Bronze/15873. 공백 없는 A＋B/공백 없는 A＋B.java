import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		
		int[] arr = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			int a = s.charAt(i)-'0';
			arr[i]= a;
		}
		
		for(int i=1; i<s.length(); i++) {
			if(arr[i]==0) {
				arr[i-1] = arr[i-1]*10;
			}
		}
		int sum =0;
		for(int i=0; i<s.length(); i++) {
			sum+= arr[i];
		}		
		System.out.println(sum);
	}
}
