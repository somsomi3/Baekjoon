import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String []args) throws IOException {
        //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = bf.readLine().split(" ");
        int A = Integer.parseInt(temp[0]);
        int B = Integer.parseInt(temp[1]);
        int C = Integer.parseInt(temp[2]);

        System.out.println((A+B)%C);
        System.out.println( ((A%C) + (B%C))%C );
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);

    }
}