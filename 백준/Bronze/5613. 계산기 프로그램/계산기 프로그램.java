import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력순서 중요
		
		long result = Long.parseLong(br.readLine());
		//숫자
		
		while(true) {
			String yunSan = br.readLine();
			//string

			if(yunSan.equals("=")) {
				System.out.println(result);
				break;
			}
			//string 판별
			
			long num = Long.parseLong(br.readLine());
			//숫자판별
			
			if(yunSan.equals("+")) {
				result+= num;
			}else if(yunSan.equals("-")) {
				result-=num;
			}else if(yunSan.equals("*")) {
				result*=num;
			}else if(yunSan.equals("/")) {
				result /= num;
			}
		}
		
	}
}
