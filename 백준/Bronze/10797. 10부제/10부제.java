import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = br.readLine().split(" ");
		
		int count =0;
		for(String r : arr) {
			if(Integer.parseInt(r)==N)count++;
		}
		System.out.println(count);
	}
}
