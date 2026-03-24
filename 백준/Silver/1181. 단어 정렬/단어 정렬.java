import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i = 0; i< N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, (a, b)->{
			if(a.length()!= b.length()) {
				return a.length()- b.length();
			}
			return a.compareTo(b);
		});
		
		StringBuilder sb = new StringBuilder();
		
		//단, 중복된 단어는 하나만 남기고 제거해야 한다.
		sb.append(arr[0]).append('\n');
		
		for(int i = 1; i < N; i++) {
			if(!arr[i].equals(arr[i-1])) {
				sb.append(arr[i]).append('\n');
			}
		}
		System.out.println(sb);
		
	}
}	
