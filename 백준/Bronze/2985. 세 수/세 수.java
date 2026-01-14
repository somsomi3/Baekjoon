import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a+b ==c) {
			System.out.println(a+"+"+b+"="+c);
		}else if(a-b ==c) {
			System.out.println(a+"-"+b+"="+c);
		}else if(a*b==c) {
			System.out.println(a+"*"+b+"="+c);
		}else if(a/b==c) {
			//나머지 유무 신경써야할듯?아 신경 안써도됨. =>항상 정답이 존재하는 경우만 입력으로 주어진다.
			System.out.println(a+"/"+b+"="+c);
		}
		
		
		else if(b+c ==a) {
			System.out.println(a+"="+b+"+"+c);
		}else if(b-c ==a) {
			System.out.println(a+"="+b+"-"+c);
		}else if(b*c==a) {
			System.out.println(a+"="+b+"*"+c);
		}else if(b/c==a) {
			//나머지 유무 신경써야할듯?아 신경 안써도됨. =>항상 정답이 존재하는 경우만 입력으로 주어진다.
			System.out.println(a+"="+b+"/"+c);
		}
	}
}
