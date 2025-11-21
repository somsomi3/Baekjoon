import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int sum = 0;
		
		for(char c : s.toCharArray()) {
			if (c >= 'A' && c <= 'C') sum += 3;
            else if (c <= 'F') sum += 4;
            else if (c <= 'I') sum += 5;
            else if (c <= 'L') sum += 6;
            else if (c <= 'O') sum += 7;
            else if (c <= 'S') sum += 8;
            else if (c <= 'V') sum += 9;
            else sum += 10;
        }

        System.out.println(sum);
    }
}