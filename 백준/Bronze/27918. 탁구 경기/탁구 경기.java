import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int Dcnt = 0;
		int Pcnt = 0;
		for(int i=0; i<N; i++) {
			String c = br.readLine();
			
			if(c.equals("D"))Dcnt++;
			else Pcnt++;
			
			if(Math.abs(Dcnt-Pcnt)>=2)break;
		}
		
		System.out.println(Dcnt+":"+Pcnt);
		
	}
}
