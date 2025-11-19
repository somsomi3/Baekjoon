import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//여러개의 테스트 케이스...?		
		String line;
		while((line = br.readLine()) != null) {
			if(line.trim().isEmpty())continue;
			StringTokenizer st = new StringTokenizer(line);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(A+B);	
		}		
	}
}