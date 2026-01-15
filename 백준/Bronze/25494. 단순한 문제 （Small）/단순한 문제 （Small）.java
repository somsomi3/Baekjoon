import java.io.*;
import java.util.*;
//7'29''
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int count =0;
			for(int j =1; j<=a; j++) {
				for(int k=1; k<=b; k++) {
					for(int l=1; l<=c; l++) {
						if((j%k==k%l)&&(k%l==l%j)) {
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}