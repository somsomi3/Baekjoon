import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr= new int[9];
		
		for(int i = 0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int x = arr[0];
		int ans = 0;
		
		for(int i = 1; i < 9; i++) {
			if(x< arr[i]) {
				x = arr[i];
				ans = i;
			}
		}
		
		System.out.println(x+ "\n" +(ans+1));
	}
}
