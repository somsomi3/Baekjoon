import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
//		String x = (Stirng) ((N/4)* 'long ' + 'int');	
		for(int i= 1; i<= N/4; i++) {
			System.out.print("long ");
		}	
		System.out.println("int");
	}
}