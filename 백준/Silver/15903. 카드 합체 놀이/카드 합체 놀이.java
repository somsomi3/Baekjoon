import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			long x =Integer.parseInt(st.nextToken());
			pq.add(x);
		}
		
		for(int i =0; i<M; i++) {
			long x = pq.poll();
			long y = pq.poll();
			long xy = x + y;
			pq.add(xy);
			pq.add(xy);
		}
		long sum = 0;
		while(!pq.isEmpty()) {
			sum+= pq.poll();
		}
		
		System.out.println(sum);
	}
}