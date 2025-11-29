import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int[] arr = new int[N];
		
		for(int i =1; i<=N/2; i++){
			if(N%i==0) {
				pq.add(i);
			}

		}pq.add(N);  
		int x =0;
		if(pq.size()<K)System.out.println(0);
		else {
			for(int j =1; j<=K; j++) {
				x =pq.poll();
			}
			System.out.println(x);
		}

	}
}
