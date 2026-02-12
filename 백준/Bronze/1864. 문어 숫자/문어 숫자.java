import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		map.put('-', 0);
		map.put('\\', 1);
		map.put('(', 2);
		map.put('@', 3);
		map.put('?', 4);
		map.put('>', 5);
		map.put('&', 6);
		map.put('%', 7);
		map.put('/', -1);
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
//			if(s==null)break;
			if(s.equals("#")) break;
			
			int result = 0;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int x = map.get(c);
				result = result * 8 + x;
				
			}
			sb.append(result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
}
