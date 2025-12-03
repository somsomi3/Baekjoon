import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count =0;
		for(int i=0; i<5; i++) {
			if(Integer.parseInt(st.nextToken())==N)count++;
		}
		System.out.println(count);
	}
}
