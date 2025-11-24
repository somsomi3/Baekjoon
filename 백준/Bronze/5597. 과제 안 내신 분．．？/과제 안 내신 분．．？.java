import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=1; i<=28; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i =1; i<=30; i++) {
			//set의 contains쓰기
			if(!set.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
