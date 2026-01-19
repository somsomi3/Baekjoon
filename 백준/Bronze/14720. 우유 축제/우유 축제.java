import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
		int count=0;
		int prev = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0 && prev == -1) {
                count++;
                prev = 0;
            } else if (arr[i] == 1 && prev == 0) {
                count++;
                prev = 1;
            } else if (arr[i] == 2 && prev == 1) {
                count++;
                prev = 2;
            } else if (arr[i] == 0 && prev == 2) {
                count++;
                prev = 0;
            }
        }
		
		System.out.println(count);
	}
}
