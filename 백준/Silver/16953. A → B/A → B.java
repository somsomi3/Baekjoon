import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 1;
			
		while(B>A) {
//			if(B==A) break;
			//루프 끝난 후에 체크 해 줘야함.
			
			if(B%2==0) {
				B = B/2;
//				cnt++;
			}else if(B%10==1) {
				B = (B-1)/10;
//				cnt++;
			}else {
				break;
			}
			cnt++;

		}
		
//		System.out.println(flag==true? -1: cnt);	
        if(B == A) System.out.println(cnt);
        else System.out.println(-1);
	}
}
