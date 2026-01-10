import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
//		String[] arr = new String[N];
        HashSet<String> set = new HashSet<>();
		
		for(int i =0; i<N; i++) {
			String s = br.readLine();
			String rev = new StringBuilder(s).reverse().toString();
			
			//포함한다면
            if (s.equals(rev) || set.contains(rev)) {
				System.out.println(s.length()+" "+s.charAt(s.length()/2));
				return; //return은 프로그램 종료,
//				break; //break는 반복문만 종료
			}
			
			//포함하지 않는다면,
			set.add(s);
		}
		
	}
}