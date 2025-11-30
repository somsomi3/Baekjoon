import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		//N=36진법수 s를 10진법수로 출력하라.
	    int result = 0;
		for(int i =0; i<s.length(); i++) {
			char c = s.charAt(i);
			int value;
            if (c >= '0' && c <= '9') value = c - '0';
            else value = c - 'A' + 10;
            result = result * N + value;
		}
        System.out.println(result);
	}
}