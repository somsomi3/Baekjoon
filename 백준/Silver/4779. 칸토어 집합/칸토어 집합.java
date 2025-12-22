import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;
	static void cant(int start, int len) {
		if(len ==1)return;
		int third = len/3;
		
        for (int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' ';
        }
		cant(start,third);
        cant(start + 2 * third, third);// 마지막 third는 end값이 아니라, len이라서 길이 입니다^^
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while((line = br.readLine())!=null) {
		    int N = Integer.parseInt(line);
		    
			int len  = (int )Math.pow(3, N);
			//Math.pow의 반환타입은 double이다.
			
			arr= new char[len];
			for(int i=0; i<len; i++) {
				arr[i] = '-';
			}
			
			//인쇄를 while안에서 하기
			cant(0, len);
			
			//출력

			System.out.println(new String(arr));
		}
		
	}
}
