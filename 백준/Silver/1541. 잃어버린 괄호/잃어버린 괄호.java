import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();	
		String[] arr = s.split("-");
		
		int ans = 0;
		
		//첫 뭉치
		String[] one = arr[0].split("\\+");
		for(String x: one) {
			ans += Integer.parseInt(x);
		}
		
		//나머지는 더하기 
		for(int i = 1; i< arr.length; i++) {
			String[] plus = arr[i].split("\\+");
		    int sum = 0;
		    
		    for(String num : plus) {
		        sum += Integer.parseInt(num);
		    }
		    ans -= sum;
		}

		System.out.println(ans);
	}
}
