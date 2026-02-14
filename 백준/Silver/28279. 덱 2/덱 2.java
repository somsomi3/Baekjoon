import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			
			if(x==1) {
				int y = Integer.parseInt(st.nextToken());
				dq.addFirst(y);	
			}else if(x==2) {
				int y = Integer.parseInt(st.nextToken());
				dq.addLast(y);
			}else if(x==3) {
				if(!dq.isEmpty()) {
					sb.append(dq.pollFirst()).append("\n");
				}else sb.append(-1).append("\n");
			}else if(x==4) {
				if(!dq.isEmpty()) {
					sb.append(dq.pollLast()).append("\n");
				}else sb.append(-1).append("\n");
			}else if(x==5) {
				sb.append(dq.size()).append("\n");
			}else if(x==6) {
				if(dq.isEmpty())sb.append(1).append("\n");
                else sb.append(0).append("\n");
			}else if(x==7) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekFirst()).append("\n");
				}else sb.append(-1).append("\n");
			}else if(x==8) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekLast()).append("\n");
				}else sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}
}	
