import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//1.stack 
		
		Stack<Character> stack = new Stack<>();
		
		
		for(int i =0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char x = s.charAt(j);//숫자..... 어떻게 받는 정형화 된 틀 알아두기.
				stack.push(x);
			}
			StringBuilder sb = new StringBuilder();
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			System.out.println(sb);
		}	
	}	
}
