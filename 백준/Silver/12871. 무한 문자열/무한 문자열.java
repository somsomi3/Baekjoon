import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		String t = br.readLine();
		
		String a = s.repeat(t.length());
		String b = t.repeat(s.length());
		
        if (a.equals(b)) System.out.println(1);
        else System.out.println(0);
    }
}