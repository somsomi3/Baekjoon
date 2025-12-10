import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		//카운팅 배열 만들기
		//각 입력의 처음 [0]자리를 읽어서 저장해서 카운팅
		//카운팅이 5를 넘는 인덱스만을 문자로 변경해서 출력
		//for 문돌려서 sb.apend로 출력시 공백 없이.출력	
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[26];
		for(int i =0; i<N; i++) {
			String s = br.readLine();
			
			for(int j =0; j<1; j++) {
				int x = s.charAt(j)-'a';
				count[x]++;
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<26; i++) {
			if(count[i]>=5) {
				sb.append((char)(i+'a'));
			}
		}
		if(sb.length()>=1)System.out.println(sb);
		else System.out.println("PREDAJA");
	}
}