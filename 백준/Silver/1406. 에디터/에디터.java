import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		String s = br.readLine();
		
		for(char c: s.toCharArray()) {
//			stack1.add(c);
			stack1.push(c);		
		}
		
		int N = Integer.parseInt(br.readLine());
		

        while (N-- > 0) {
            String cmd = br.readLine();
            char c = cmd.charAt(0);
            
            
            if(c=='P') {
            	stack1.push(cmd.charAt(2));
            }else if(c=='L') {
//            	while(!stack1.isEmpty()) {
                if (!stack1.isEmpty()) {
            		stack2.push(stack1.pop());
            	}
            }else if(c=='B') {
//            	while(!stack1.isEmpty()) {
                if (!stack1.isEmpty()) {
            		stack1.pop();
            	}
            }else if(c=='D') {
            	if (!stack2.isEmpty()) {
            		stack1.push(stack2.pop());
            	}
            }
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : stack1) sb.append(c);
		while (!stack2.isEmpty()) sb.append(stack2.pop());

		System.out.println(sb);
	}
}