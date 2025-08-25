import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N= Integer.parseInt(br.readLine());
		
		int[] rope = new int[N];
		
		for (int i=0 ; i<N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
        Arrays.sort(rope); // 오름차순 정렬

        int max = 0;
        for(int i=0; i<N; i++) {
        	int w = rope[i]*(N-i);
        	if (w >max) {
        		max =w;
        	}
        }
        System.out.println(max);
	}

}
