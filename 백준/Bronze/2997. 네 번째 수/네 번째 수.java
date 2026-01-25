import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		
		for(int i =0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int x = arr[1]-arr[0];
		int y = arr[2]-arr[1];

		int ans = 0;

		if(x>y) {
			ans = arr[0]+y;
		}else if(x<y) {
			ans = arr[1]+x;
		}else {
			ans = arr[2]+x;
		}
		
		System.out.println(ans);

	}
}
