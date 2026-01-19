import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long R = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		
		long x = R / N;
		if (R % N != 0) x++;

		long y = C / N;
		if (C % N != 0) y++;

		System.out.println(x * y);

	}
}
