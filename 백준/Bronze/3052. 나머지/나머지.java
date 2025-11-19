import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10];
		for(int i =0; i<10; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		Set<Integer> set = new HashSet<>();

		for(int i =0; i<10; i++) {
			set.add(arr[i]%42);
		}
		
		int x = set.size();
		bw.write(String.valueOf(x));
	
		
		bw.flush();
		bw.close();
	}
}
