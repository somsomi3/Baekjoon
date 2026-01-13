import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		String[] set = new String[N];
//		HashSet<String> set = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set[i] = br.readLine();
		}

		for(int i =0; i<M; i++) {
			set2.add(br.readLine());
		}
		
		
        List<String> result = new ArrayList<>();
		
		
        for (int i = 0; i < N; i++) {
            if (set2.contains(set[i])) {
                result.add(set[i]);
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (String name : result) {
            sb.append(name).append('\n');
        }

        System.out.print(sb);
    }
}