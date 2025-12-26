import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int su;
		while((su=Integer.parseInt(br.readLine()))!=0) {
			if(su%N==0)System.out.println(su+" is a multiple of "+N+".");
			else System.out.println(su+" is NOT a multiple of "+N+".");
		}
		
	}
}
