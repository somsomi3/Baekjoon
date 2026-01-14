import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			
			map.put(s, map.getOrDefault(s, 0)+1);
			
		}
        int max = 0;
        String ans = "";

        for (String key : map.keySet()) {
            int cnt = map.get(key);

            if (cnt > max || (cnt == max && key.compareTo(ans) < 0)) {
                max = cnt;
                ans = key;
            }
        }

        System.out.println(ans);
    }
}