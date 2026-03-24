import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			HashMap<String, Integer>map = new HashMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i<N; i++) {
				String s = br.readLine();
				
				StringTokenizer st = new StringTokenizer(s);
				String name = st.nextToken(); // 필요없음
                String type = st.nextToken(); // 중요

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (int count : map.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }
    }
}