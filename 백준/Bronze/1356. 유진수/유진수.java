import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int N = Integer.parseInt(st.nextToken());
		String t = br.readLine();
		String[] s = t.split("");
		
		int[] arr = new int[t.length()];
		for (int i = 0; i < t.length(); i++) {
		    arr[i] = Integer.parseInt(s[i]);
		}
		
        boolean ok = false;

		//i를 막잡아보자
		for(int i=1; i<t.length(); i++) {
			int left =1;
			int right =1;
			
			 for (int j = 0; j < i; j++) {
	                left *= arr[j];
	            }
	            for (int j = i; j < t.length(); j++) {
	                right *= arr[j];
	            }

	            if (left == right) {
	                ok = true;
	                break;
	            }
	        }

	        System.out.println(ok ? "YES" : "NO");
	}
}