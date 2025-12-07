import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		while (s != null) {
		    System.out.println(s);
		    s = br.readLine();
		}
	}
}