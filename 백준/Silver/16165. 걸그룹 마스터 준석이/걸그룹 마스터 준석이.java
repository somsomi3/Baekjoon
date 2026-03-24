import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(st.nextToken()); // 그룹 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수
		
        Map<String, List<String>> groupMap = new HashMap<>();

		Map<String, String> allMap = new HashMap<>();

        
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();

            for (int j = 0; j < cnt; j++) {
                String member = br.readLine();

                list.add(member);
                allMap.put(member, group);
            }

            Collections.sort(list); // 사전순 정렬
            groupMap.put(group, list);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                List<String> list = groupMap.get(name);
                for (String member : list) {
                    sb.append(member).append('\n');
                }
            }

            else {
                sb.append(allMap.get(name)).append('\n');
            }
        }

        System.out.print(sb);
    }
}