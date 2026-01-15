import java.io.*;
import java.util.*;
//6'26''
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans =0;
			for(int j =1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					if((j*j+k*k+m)%(j*k)==0) {
						ans++;
					}
				}
			}
			System.out.println(ans);
			
		}
	}
}
