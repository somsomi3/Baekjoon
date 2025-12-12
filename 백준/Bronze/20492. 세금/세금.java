import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int x = N/100*78;//N이 1000의 배수라서 100으로 나눠도 나머지가 안생겨서 이렇게 해도됨
		int y = N- (N/5)/100*22;
		
		System.out.println(x+" "+y);
	}
}
