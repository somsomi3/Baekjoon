import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		List<String>list = new ArrayList<>();
		
		for(int i = 0; i<M; i++) {
			String t = br.readLine();
			if(set.contains(t)) {
				list.add(t);
			}
		}
		
		list.sort((a, b)-> a.compareTo(b));
		
		sb.append(list.size()).append("\n");
		
		for(int i = 0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}