import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int[] arr = new int[3];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i =0; i<3; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(Integer.parseInt(st.nextToken()));
		}
	
		for(int j =0; j<3; j++) {
			System.out.print(pq.poll()+ " ");		
		}
	}
}
