import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 1000001;
		
		for(int i=0; i<5; i++) {
			for(int j =i+1; j<5; j++) {
				for(int k=j+1; k<5; k++) {
					int cur = lcm(lcm(arr[i], arr[j]), arr[k]);
					ans = Math.min(ans, cur);
				}
			}
		}
		System.out.println(ans);
		
		
		
	}
	static int gcd(int a, int b) {
		while(b!=0) {// 음수도 가능하므로, b>0이 아니라, b!=을 써야한다.
			int r = a%b;
			a = b;
			b= r;
		}
        return a;
	}
	
	static int lcm(int a, int b) {
		return a/gcd(a, b)*b;
	}
}