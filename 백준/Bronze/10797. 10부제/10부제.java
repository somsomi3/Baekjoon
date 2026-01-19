import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		int[] arr = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		int count =0; 
		for(int i =0; i<5; i++) {
			if(a==arr[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
}
