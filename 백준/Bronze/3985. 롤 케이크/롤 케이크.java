import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L+1];
		boolean[] visited = new boolean[L+1];
		
		
		int M = Integer.parseInt(br.readLine());
		int[] count = new int[M+1];
		
		int max =0;
		int ans =0;//방청객 번호
		for(int i = 1; i<=M; i++) { //방청객은 1부터 시작한다.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int x = k-p+1;
			if(x>max) {
				max =x;
				ans = i;//그때의 방청객 번호
			}
			
			for(int y = p; y<=k; y++) {
				if(!visited[y]) {
					visited[y]= true;
					arr[y]= i;
				}
			}
		}
		
		for(int i=1; i<=L; i++) {
			count[arr[i]]++;
		}
		int mmax =0;
		int aans =0;
		for(int i=1; i<=M; i++) {
			if(count[i]>mmax) {
				mmax = count[i];
				//출력하는 방청객 번호
				aans = i;
			}
		}

		//정답
		//1.예상" 방청객의 번호"
		System.out.println(ans);
		
		//2.진짜 많은 조각을 받는 "방청객의 번호"
		System.out.println(aans);
	}
}