import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//최소힙
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(num);
                
                if(pq.size() > N) {
                	//가장 작은 수가 빠져나옴.
                    pq.poll();
                }
                //PQ의 상태
                //[35, 41, 48, 49, 52]
            }
        }
        System.out.println(pq.peek());
    }	
}

