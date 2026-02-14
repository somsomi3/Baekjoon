import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//최대 10억 *100이 나올 수 있기 때문에, long을 사용하자. 
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		
		long z = (y*100)/x;
		
		//100인 경우에는 어차피 -1
		if(z>=99) {
			System.out.println(-1);
			return;
		}
		
		long left = 1;
		long right = 1_000_000_000;
		long answer = -1;
		
		while(left <= right) {
			long mid = (left+right) / 2;
			
			long zz = ((y+mid)*100/(x+mid));
			
			if(zz>z) {
				answer = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}

        System.out.println(answer);
	}
}
