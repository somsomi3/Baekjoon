import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			
			StringBuilder sb = new StringBuilder();
            sb.append("god");
            
            for (int j = 1; j < arr.length; j++) {
            	sb.append(arr[j]);
            }
            
    		System.out.println(sb);
		}
	}
}
