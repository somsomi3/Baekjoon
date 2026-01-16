import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i =0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean flag = false;
			int[] arr = new int[3];
			for(int j=0; j<3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int x = arr[0];
			int y = arr[1];
			int z = arr[2];
			
			if(x*x+y*y==z*z) {
				flag =true;
			}
			int a = i+1;
			if(flag)sb.append("Scenario #"+a+":").append("\n").append("yes").append("\n").append("\n");
			else sb.append("Scenario #"+a+":").append("\n").append("no").append("\n").append("\n");
			
		}
		System.out.println(sb);
		
	}
}
