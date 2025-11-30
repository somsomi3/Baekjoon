import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		String s = br.readLine();
//		
//        if (s.equals("A+")) System.out.println("4.3");
//        else if (s.equals("A0")) System.out.println("4.0");
//        else if (s.equals("A-")) System.out.println("3.7");
//        else if (s.equals("B+")) System.out.println("3.3");
//        else if (s.equals("B0")) System.out.println("3.0");
//        else if (s.equals("B-")) System.out.println("2.7");
//        else if (s.equals("C+")) System.out.println("2.3");
//        else if (s.equals("C0")) System.out.println("2.0");
//        else if (s.equals("C-")) System.out.println("1.7");
//        else if (s.equals("D+")) System.out.println("1.3");
//        else if (s.equals("D0")) System.out.println("1.0");
//        else if (s.equals("D-")) System.out.println("0.7");
//        else System.out.println("0.0");
		
		
		//해쉬맵
//		HashMap<String, String> map = new HashMap<>();// 정확히 부동소수점 에러를 피하려면 String해서 "4.3"이렇게 하자.
		HashMap<String, Double> map = new HashMap<>();
		
		map.put("A+", 4.3);
		map.put("A0", 4.0);
		map.put("A-", 3.7);
		
		map.put("B+", 3.3);
		map.put("B0", 3.0);
		map.put("B-", 2.7);
		
		map.put("C+", 2.3);
        map.put("C0", 2.0);
        map.put("C-", 1.7);
        map.put("D+", 1.3);
        map.put("D0", 1.0);
        map.put("D-", 0.7);
        map.put("F", 0.0);

        String s = br.readLine();
        System.out.println(map.get(s));
    }
}