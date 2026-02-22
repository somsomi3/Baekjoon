import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[num];
			int sum = 0;
			
			int[] ans = new int[N];

			for(int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];

			}
            double avg = (double) sum / num;
			
			int cnt = 0;
			for(int j = 0; j < num; j++) {
				if(arr[j] > avg) cnt++;
			}
			double percent = (double) cnt / num * 100;
            System.out.printf("%.3f%%\n", percent);
		}			
	}
}