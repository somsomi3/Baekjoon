import java.io.*;
import java.util.*;

public class Main {
	static class Two{
		String s;
		int sum;
		Two(String s, int sum){
			this.s = s;
			this.sum = sum;
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		List<Two> list = new ArrayList<>();
		
		for(int i =0; i<N; i++) {
			 String s = br.readLine();
			 int sum = 0;
			 for (int j = 0; j < s.length(); j++) {
			     if (Character.isDigit(s.charAt(j))) {//중요!: 이 문자에대해, 이문자가 숫자인가? 라는 뜻.
			         sum += s.charAt(j) - '0';
			     }
			 }
			 
			 list.add(new Two(s, sum));
		}

		list.sort((a,b)-> {
			if (a.s.length() != b.s.length()) {
			    return a.s.length() - b.s.length();
			} else if (a.sum != b.sum) {
			    return a.sum - b.sum;
			} else {
			    return a.s.compareTo(b.s);
			}
//            if (a.s.length() != b.s.length()) {
//                return a.s.length() - b.s.length();
//            }
//            if (a.sum != b.sum) {
//                return a.sum - b.sum;
//            }
//            return a.s.compareTo(b.s);
			
		});
		
        StringBuilder sb = new StringBuilder();
        for (Two t : list) {
            sb.append(t.s).append('\n');
        }

        System.out.print(sb);
    }
}