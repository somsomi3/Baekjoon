import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		if(N==60 && M==60 && F==60) {
			System.out.println("Equilateral");
		}else if(N+M+F==180) {
			if(N==M || M==F|| N==F) {
				System.out.println("Isosceles");
			}else if(N!= M && M!=F && N!=F) {
				System.out.println("Scalene");
			}
		}else {
			System.out.println("Error");
		}
	}
}
