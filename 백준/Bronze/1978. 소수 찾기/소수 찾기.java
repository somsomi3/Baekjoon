import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count =0;
		//에라토스 테네스의 체,,., 흠 체를 어떻게 구현하더라... 가장 큰수의 /2만큼 만해서 나눠지지 않으면 됫던가?
		//i*i까지의 범위는 제곱수 였나?
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if(cutcut(a)) {
				count++;
			}

		}
		System.out.println(count);
		
	}
	static boolean cutcut(int a) {
		if (a < 2) return false;
		for (int j=2; j*j <= a; j++) {
            if (a % j == 0) return false;
        }
        return true;
	}
}