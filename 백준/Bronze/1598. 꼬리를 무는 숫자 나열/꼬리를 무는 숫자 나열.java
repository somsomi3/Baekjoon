import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//4인경우 예외처리 주의
        int x1 = (N - 1) / 4;
        int y1 = (N - 1) % 4;

        int x2 = (M - 1) / 4;
        int y2 = (M - 1) % 4;
		
		int result = Math.abs(x1-x2)+Math.abs(y1-y2);
		
		System.out.println(result);
	}
}