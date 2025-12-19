import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char s = br.readLine().charAt(0);
		if(s=='N'|| s=='n') {
			System.out.println("Naver D2");
			
		}else System.out.println("Naver Whale");
	}
}
