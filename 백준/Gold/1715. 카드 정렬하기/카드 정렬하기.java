import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int[] arr = new int[N];
		for(int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i<N; i++) {
			pq.offer(arr[i]);
		}
		
        int total = 0;
		
		while(pq.size()>1) {
//			sum+= pq.poll();
//			sum+= sum;
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b;
            total += sum;

            pq.offer(sum);
		}
		
        System.out.println(total);
	}
}