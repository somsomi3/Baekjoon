import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();

		if (s.isEmpty()) {
		    System.out.println(0);
		    return;
		}

		String[] ss = s.split(" ");
		
		int x = ss.length;

		System.out.println(x);
		
	}
}