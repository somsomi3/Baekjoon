import java.io.*;
import java.util.*;

public class Main {
	static int K, r;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] level;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
        
		r = 1;
		for(int i = 0; i<K; i++) {
			r*= 2;
		}
		r-=1;
		
		arr = new int[r];
		level = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            level[i] = new ArrayList<>();
        }
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		solve(0, r - 1, 0);
        for (int i = 0; i < K; i++) {
            for (int num : level[i]) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
	}
	static void solve(int start, int end, int depth) {
		if (start > end) return;
		int mid = (start+end)/2;
		
		//중간 출력 및 줄바꾸기
//		sb.append(arr[mid]).append("\n");
		
		level[depth].add(arr[mid]);

		solve(start, mid - 1, depth + 1);
	    solve(mid + 1, end, depth + 1);
	}
}