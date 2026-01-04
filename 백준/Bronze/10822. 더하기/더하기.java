import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String[] parts = br.readLine().split(",");
		
        int sum=0;
        for(String s: parts) {
        	sum += Integer.parseInt(s);
        }
        System.out.println(sum);
	}
}
