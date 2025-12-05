import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N= Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			String[] arr = s.split(",");
			
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);

			System.out.println(A + B);

		}
		
	}
}
