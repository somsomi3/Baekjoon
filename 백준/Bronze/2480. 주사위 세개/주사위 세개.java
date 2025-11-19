import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map.put(a, map.getOrDefault(a, 0) + 1);
		map.put(b, map.getOrDefault(b, 0) + 1);
		map.put(c, map.getOrDefault(c, 0) + 1);
		
		int price = 0;
		
		for(int key: map.keySet()) {
			int count =map.get(key);
			
			
            if (count == 3) {
                price = 10000 + key * 1000;
            } else if (count == 2) {
                price = 1000 + key * 100;
            }
		}
		  if (price == 0) {
	            int max = Math.max(a, Math.max(b, c));
	            price = max * 100;
	        }

	        System.out.println(price);
	}
}