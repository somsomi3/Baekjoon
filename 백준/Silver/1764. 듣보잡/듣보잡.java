import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		List<String> ans = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		int cnt = 0;
		
		for(int i = 0; i<M; i++) {
			String t = br.readLine();
			
			if(set.contains(t)) {
				cnt++;
				ans.add(t);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		System.out.println(cnt);
		
		//사전 순 출력,...
		Collections.sort(ans);  // 사전순 정렬
		
		for(String s : ans) {
            sb.append(s).append("\n");
        }

		System.out.println(sb);
	}
}