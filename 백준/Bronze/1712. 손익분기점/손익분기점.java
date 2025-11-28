import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int y = C-B;
		
		int x = 1;
        
        if (C <= B) {
            System.out.println(-1);
            return;
        }
		while(y*x -A<=0) {
			x+=1;
		}
		System.out.println(x);
	}
}
