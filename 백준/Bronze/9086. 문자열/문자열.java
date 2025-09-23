import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<N; i++) {
            String doc= br.readLine();
            char x = doc.charAt(0);
            char y= doc.charAt(doc.length()-1);
            sb.append(x).append(y).append("\n");
            
        }
        System.out.print(sb);
    }

}
