import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//우선 순위 큐를 써보자.
		PriorityQueue<Integer> wpq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> kpq = new PriorityQueue<>(Collections.reverseOrder());		
		
		for(int i =0; i<10; i++) {
			wpq.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i =0; i<10; i++) {
			kpq.add(Integer.parseInt(br.readLine()));
		}
		
		int wSum =0;
		int kSum =0;
		for(int i= 0; i<3; i++) {
			wSum +=wpq.poll();
			kSum +=kpq.poll();
		}

		System.out.println(wSum+" "+kSum);
	}
}
