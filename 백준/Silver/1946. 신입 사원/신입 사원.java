import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][2];

			for (int i = 0; i < N; i++) {
			    StringTokenizer st = new StringTokenizer(br.readLine());
			    arr[i][0] = Integer.parseInt(st.nextToken()); // 서류
			    arr[i][1] = Integer.parseInt(st.nextToken()); // 면접
			}

			Arrays.sort(arr, (a, b)-> a[0] -b[0]);
			
			int cnt =1;
			int minishell = arr[0][1];
			
			for(int i =1; i<N; i++) {
				if(arr[i][1]<minishell) {//더작아야
					minishell = arr[i][1];
					cnt++;//합격
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
