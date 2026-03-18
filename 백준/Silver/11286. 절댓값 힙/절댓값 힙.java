import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(
			(a, b)->{
				if(Math.abs(a) == Math.abs(b)) {
					return a - b;//작은 값 먼저
				}
				//같지 않다면
				return Math.abs(a) - Math.abs(b); //작은 절댓갑 부터
			}
		);
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<T; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append('\n');
				}
				else{
					sb.append(0).append('\n');
				}
			}
			else pq.offer(x);
		}
		System.out.println(sb);
	}
}
