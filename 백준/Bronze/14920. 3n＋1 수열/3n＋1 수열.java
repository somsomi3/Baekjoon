import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt =1;
		while(N>0) {
			if(N==1) {
				System.out.println(cnt);
				break;
			}else if(N%2==0) {
				N=N/2;
				cnt++;
			}else if(N%2!=0) {
				N = 3*N+1;
				cnt++;
			}
		}
		
	}
}
