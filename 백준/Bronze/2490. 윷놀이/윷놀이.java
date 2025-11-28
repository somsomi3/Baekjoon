import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i<3; i++) {
			int countZero =0;
//			int countOne = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0 ; j<4; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==0) {
					countZero++;
//				}else {
//					countOne++;
				}
				
			}
			if(countZero==1)System.out.println("A");
			if(countZero==2)System.out.println("B");
			if(countZero==3)System.out.println("C");
			if(countZero==4)System.out.println("D");
			if(countZero==0)System.out.println("E");
			}
			
	}
}
