import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N;
		int sum =0;
		while((N=Integer.parseInt(br.readLine()))!=-1) {
			sum+=N;
		}
		System.out.println(sum);
	}
}