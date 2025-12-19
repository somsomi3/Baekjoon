import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i= 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int mid = Integer.parseInt(st.nextToken());
			
			
			//임시 배열 하나 만들기
			int[] temp = new int[end - begin + 1];
            int idx = 0;
			
            for (int j = mid; j <= end; j++) {
                temp[idx++] = arr[j];
            }
            for (int j = begin; j < mid; j++) {
                temp[idx++] = arr[j];
            }
            
            //arr에서 바꿔야하는 부분범위만 temp로 바꾸기
            idx = 0;
            for (int j = begin; j <= end; j++) {
                arr[j] = temp[idx++];
            }
            
            
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}