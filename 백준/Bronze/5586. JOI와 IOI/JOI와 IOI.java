import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		
		int joiCount =0;
		int ioiCount =0;
		
		for(int i=0; i<=s.length()-3; i++) {//시작~끝까지 총 3개니까 최대범위는 s.length()-3이다.
			char a = s.charAt(i);
			char b = s.charAt(i+1);
			char c = s.charAt(i+2);
			
			//두 조건이 “논리적으로 독립”이기 때문 if, if를 사용한다.
			if(a=='J'&&b=='O'&&c=='I')joiCount++;
			if(a=='I'&&b=='O'&&c=='I')ioiCount++;
		}
		
        System.out.println(joiCount);
        System.out.println(ioiCount);
	}
	
}
