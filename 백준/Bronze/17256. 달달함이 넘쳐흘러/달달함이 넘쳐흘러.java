import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		int[] crr = new int[3];
		
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			crr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] brr = new int[3];
		brr[0] = crr[0] - arr[2];
		brr[1] = crr[1]/ arr[1];
		brr[2] = crr[2]-arr[0];
		
		for(int i=0; i<3; i++) {
			System.out.print(brr[i]+" ");
		}
	}
}