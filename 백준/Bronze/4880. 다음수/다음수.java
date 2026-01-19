import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String s = br.readLine();
			if(s.equals("0 0 0")) break;
			StringBuilder sb = new StringBuilder();
			String[] srr = s.split(" ");
			
			int[] arr = new int[3];
			for(int i=0; i<3; i++) {
				arr[i] = Integer.parseInt(srr[i]);	
			}
			
			if(arr[1]-arr[0]==arr[2]-arr[1]) {
				sb.append("AP ").append(arr[2]+(arr[1]-arr[0]));
				System.out.println(sb);
//			}
//			else if(arr[1]%arr[0]==0) {
			//arr[0] == 0이면 0으로 나누기 위험
			}else {
				sb.append("GP ").append(arr[2]*(arr[1]/arr[0]));
				System.out.println(sb);
				}

		}
		
	}
}