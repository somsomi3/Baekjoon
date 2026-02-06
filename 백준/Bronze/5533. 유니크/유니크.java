import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][]arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
	
		for(int i =0; i<N; i++) {
			int sum =0;
			
			for(int j = 0; j<3; j++) {
				boolean x = true;
				for (int k=0; k<N; k++) {
					if (i == k) continue;
                    if (arr[i][j] == arr[k][j]) {
                    	x = false;
                    	break;
                    }
				}
				
				if(x)sum+=arr[i][j];
			}
			
			System.out.println(sum);
		}
	}
}
