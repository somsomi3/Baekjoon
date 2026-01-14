import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer>map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split("\\.");
			String a = arr[1];
			//넣어라(a, 그리고 가져온값+1)을 .
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		
        StringBuilder sb = new StringBuilder();
		for(String key: keys) {
			sb.append(key).append(" ").append(map.get(key)).append("\n");
		}
		
		System.out.println(sb);
		
	}
}	
