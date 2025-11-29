import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }
}