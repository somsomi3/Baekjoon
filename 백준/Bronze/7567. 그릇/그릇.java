import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine(); // 한줄을 다 읽음.
		int len  = s.length();
		int sum = 10;// 어쨋던 처음 그릇은 10이다. 엥 근데 왜 5로 시작했는데 답이 맞니?
		for(int i =0; i<len-1; i++) {//끝보다 작고/ 그것보다 1더 작아야함.
			char c = s.charAt(i);
//			System.out.println(c);
			if(s.charAt(i)!=s.charAt(i+1)) {// 여기 말고 위에있는for에서 i<len-1로  해서 범위를 제한해야함. 
				sum+= 10;
			}else {
				sum+=5;
			}
		}
		System.out.println(sum);
	}
}