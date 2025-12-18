import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int  N  =Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		boolean[] row = new boolean[N];
		boolean[] col = new boolean[M];
		
		for(int i =0; i<N; i++) {
			//한줄 씩 입력받기
			String s = br.readLine();
			for(int j =0; j<M; j++) {
                if (s.charAt(j) == 'X') {
					// boolean 체크
					row[i] = true;
					col[j] = true;
				}
			}
		}
		int rowCnt = 0;
		int colCnt = 0;

		for (int i = 0; i < N; i++) {
		    if (!row[i]) rowCnt++;
		}

		for (int j = 0; j < M; j++) {
		    if (!col[j]) colCnt++;
		}
		
		System.out.println(Math.max(rowCnt, colCnt));

	}
}	
