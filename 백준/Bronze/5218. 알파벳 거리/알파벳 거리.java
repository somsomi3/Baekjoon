import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			String t = st.nextToken();
			
			int[] arr = new int[s.length()+1];
			int[] trr = new int[t.length()+1];
			
			for(int j=0; j<s.length(); j++) {
				int c = s.charAt(j)-'A'+1;
				arr[j] =c;
			}
			
			for(int j=0; j<s.length(); j++) {
				int c = t.charAt(j)-'A'+1;
				trr[j] =c;
			}
			
            System.out.print("Distances: ");
//			int x =0;		
			for(int j =0; j<s.length(); j++) {
				int x;
				if(trr[j]>= arr[j]) {
					x = trr[j]- arr[j];					
				}else {
					x = trr[j]+26- arr[j];	
				}
                System.out.print(x + " ");
			}
//			System.out.println(x);
            System.out.println();
			
		}		
	}
}