import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		String s;
		while(!(s=br.readLine()).equals("0")) {
			int count =0;
			count+=2;
			count+=s.length()-1;
			for(int i =0; i<s.length();i++) {
				char c = s.charAt(i);
				//간격과 여백은 여기서 더하면 안된다. 밖에서 그 문자s 가 시작될때 딱 한번만
//				count+=2;
//				count+=s.length()-1;
				if (c=='1') {
					count+=2;//1일때는 +1입니다. 
//					System.out.println("1일 경우= "+count);

				}else if(c=='0') {
					count+=4;
//					System.out.println("0일 경우= "+count);
				}else {
					count+=3;
//					System.out.println("나머지 경우= "+count);
				}

			}
			System.out.println(count);

		}
		
	}
}