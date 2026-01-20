import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[5];
		for(int i =1; i<=4; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		
		int ans =0;
		boolean flag = false;
		for(int i=1; i<=4; i++) {
			if(arr[i]==a) {
				flag = true;
				ans =i;
			}
		}
		if(flag)System.out.println(ans);
		else System.out.println(0);
		
	}
}
