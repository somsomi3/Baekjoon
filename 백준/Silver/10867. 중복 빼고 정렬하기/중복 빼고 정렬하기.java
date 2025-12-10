import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer>set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		 // set → 배열 변환
        Integer[] arr = set.toArray(new Integer[0]);

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
}