import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 30;
		
		int[] arr = new int[n+1];//범위주의
		for(int i=1; i<=28; i++) {//입력갯수주의
			int x = Integer.parseInt(br.readLine());
			arr[x] =x;
		}
		for(int i=1; i<=n; i++) {
			if(arr[i]==0) {
				System.out.println(i);
			}
		}	
	}
}