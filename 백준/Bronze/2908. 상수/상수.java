import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		String s = br.readLine();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int xx = reverse(N);
		int yy = reverse(M);
		
        System.out.println(Math.max(xx, yy));
    }

	public static int reverse(int start) {
		int success =0;
		for(int i =0; i<3; i++) {
			success = success*10 + start%10;
			start /=10;
		}
		return success;

	}

}
