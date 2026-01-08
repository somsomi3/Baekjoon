import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] arr = {"MatKor", "WiCys", "CyKor", "AlKor", "$clear"};
		
		char C = br.readLine().charAt(0);//이건 이런 입력 뿐인가?
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].charAt(0)==C) {
				System.out.println(arr[i]);
			}
		}
		
	}
}
