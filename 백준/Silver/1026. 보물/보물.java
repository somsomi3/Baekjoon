import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] brr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int x= Integer.parseInt(st.nextToken());
			q.add(x);
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum+= arr[i]*q.poll();
		}
		System.out.println(sum);
	}
}
