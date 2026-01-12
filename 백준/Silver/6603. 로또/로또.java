import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] ans = new int[6];
	static int N;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(true) {
			String line = br.readLine();
			if(line.equals("0"))break;
			
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			for(int i =0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			sb.append("\n");
		}
        System.out.print(sb);
	}
	static void dfs(int depth, int start) {
		if(depth==6) {
			for(int i=0; i<6; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			ans[depth]= arr[i];
			dfs(depth+1, i+1);
		}
		
	}
}