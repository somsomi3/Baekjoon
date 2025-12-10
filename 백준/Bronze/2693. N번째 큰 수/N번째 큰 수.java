import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//시간 초과 날정도의 숫자 크기나, 곱셈은 안보여서 int로 해결 가능할 듯함.
		
		int T = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[10];
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());//한줄안에서 10개를 읽어야해서 
			//for 문 안이아니라 여기에 위치함.		
			for(int i =0; i<10; i++) {
					
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, Collections.reverseOrder());
			
			System.out.println(arr[2]);
		}
	}
}
