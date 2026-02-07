import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("black", 0);
		map.put("brown", 1);
		map.put("red", 2);
		map.put("orange", 3);
		map.put("yellow", 4);
		map.put("green", 5);
		map.put("blue", 6);
		map.put("violet", 7);
		map.put("grey", 8);
		map.put("white", 9);
		
//		String[][][] arr = new String[10][10][10];
		
		int N = 3;
		String ans= "";
		for(int i=0; i<N-1; i++) {
			String s = br.readLine();
			
			int x = map.get(s);
			ans+=x;
			
		}
		
		long aans = Integer.parseInt(ans);
		
		String t = br.readLine();
		int y = map.get(t);
		
		for(int i=0; i<y; i++) {
			aans*=10;
		}
		
		System.out.println(aans);
	}
}
