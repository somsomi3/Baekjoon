import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
        int layer = 1;
        int end = 1;

        while (end < N) {
        	end += layer*6;
        	layer++;
        			
        }
        System.out.println(layer);
	}
}