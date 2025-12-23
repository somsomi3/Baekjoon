import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int r = N%8;
        if (r == 1) System.out.println(1);
        else if (r == 2) System.out.println(2);
        else if (r == 3) System.out.println(3);
        else if (r == 4) System.out.println(4);
        else if (r == 5) System.out.println(5);
        else if (r == 6) System.out.println(4);
        else if (r == 7) System.out.println(3);
        else System.out.println(2);
    }
}
