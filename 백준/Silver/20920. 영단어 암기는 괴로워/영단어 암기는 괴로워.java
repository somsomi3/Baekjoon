import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int idx =0;
		for(int i=0; i<N; i++) {
			String s= br.readLine();
			
			//map입력
//			if (s.length() >= M) {
//			    if (map.containsKey(s)) {
//			        map.put(s, map.get(s) + 1);
//			    } else {
//			        map.put(s, 1);
//			    }
//			}
			 if (s.length() < M) continue;
	            map.put(s, map.getOrDefault(s, 0) + 1);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return Integer.compare(b.getValue(), a.getValue());
            }
            if (a.getKey().length() != b.getKey().length()) {
                return Integer.compare(b.getKey().length(), a.getKey().length());
            }
            return a.getKey().compareTo(b.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append("\n");
        }

        System.out.print(sb);
	}
}