import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 10;
		int sum = 0;
		for(int i =0; i<N; i++) {
			sum+= Integer.parseInt(br.readLine());
		}
		
		int x = sum%4;
		
		if(x==0)System.out.println("N");
		else if(x==1)System.out.println("E");
		else if(x==2)System.out.println("S");
		else System.out.println("W");
	}
}
