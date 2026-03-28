import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<int[]> dq = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			dq.offer(new int[]{Integer.parseInt(st.nextToken()), i+1});
		}
		
		while(dq.size()>1) {
			int[] x = dq.poll();
			sb.append(x[1]).append(" ");
			
			if(x[0]> 0) {
				for(int i = 0; i<x[0]-1; i++) {
					dq.addLast(dq.pollFirst());	
				}
			}else {
				for(int i = 0; i<-x[0]; i++) {
					dq.addFirst(dq.pollLast());
				}
			}
		}
		int[] last = dq.poll();
		sb.append(last[1]);
		
		System.out.println(sb);
		
		
	}
}