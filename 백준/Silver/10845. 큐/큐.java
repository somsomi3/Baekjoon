import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.charAt(0)=='p') {
				if(s.charAt(1)=='u') {
					//문자열의 5번 인덱스부터 끝까지 잘라라
					int x = Integer.parseInt(s.substring(5));
					dq.add(x);
					
				}else {
					if(!dq.isEmpty()) {
						System.out.println(dq.poll());
					}else {
						System.out.println(-1);
					}
					
				}
			}else if(s.charAt(0)=='f') {
				if(!dq.isEmpty()) {
					System.out.println(dq.peekFirst());
				}else {
					System.out.println(-1);
				}
			}else if(s.charAt(0)=='b') {
				if(!dq.isEmpty()) {
					System.out.println(dq.peekLast());
				}else {
					System.out.println(-1);
				}
			
			}else if(s.charAt(0)=='s') {
				System.out.println(dq.size());
				
			}else if(s.charAt(0)=='e') {
				if(dq.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}
		
	}
}