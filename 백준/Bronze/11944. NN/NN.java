import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		int x = Integer.parseInt(s);
		int M= Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<x;i++) {
			sb.append(s);
		}
		
		if(sb.length()>M) {
			System.out.println(sb.substring(0, M));
		}else System.out.println(sb);
		
	}
}
