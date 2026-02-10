import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int cnt =0;
		while(T-->0) {
			String A = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			stack.push(A.charAt(0));
			
			for(int i=1; i<A.length(); i++) {
				char c = A.charAt(i);
				if(!stack.isEmpty() &&stack.peek()==c) {
					stack.pop();
				}else {
					stack.push(c);
				}
				
			}
			if(stack.size()==0) {
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
	}
}