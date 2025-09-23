import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int answer = 0;
		for (int i= 0; i<N; i++) {
			answer += arr[i]*(N-i);
		}
		System.out.println(answer);
	}

}
