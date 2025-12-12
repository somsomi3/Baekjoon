import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = new String[3];
		for(int i=0; i<3; i++) {
			arr[i] = br.readLine();
		}
		
		int num =0;
		int idx =0;
		
		for(int i=0; i<3; i++) {
			if(Character.isDigit(arr[i].charAt(0))) {
				num = Integer.parseInt(arr[i]);
				idx = i;
				break;
			}
		}
        int next = num + (3 - idx);

        if (next % 15 == 0) System.out.println("FizzBuzz");
        else if (next % 3 == 0) System.out.println("Fizz");
        else if (next % 5 == 0) System.out.println("Buzz");
        else System.out.println(next);
    }
}