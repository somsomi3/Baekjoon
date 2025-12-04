import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int jin = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		while(N>0) {
			int ans = N%jin;
			if(ans<10) sb.append((char)(ans+'0'));
            else sb.append((char)(ans - 10 + 'A'));
            N /= jin;
		}	
        System.out.println(sb.reverse());
	}
}
