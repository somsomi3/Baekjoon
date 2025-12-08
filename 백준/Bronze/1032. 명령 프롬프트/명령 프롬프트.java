import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int len = arr[0].length();
        StringBuilder sb = new StringBuilder();

        // 각 자리(index)를 기준으로 문자 비교
        for (int j = 0; j < len; j++) {
            char base = arr[0].charAt(j); // 기준 문자
            boolean same = true;
                   
            // 나머지 문자열과 비교
            for (int i = 1; i < N; i++) {
                if (arr[i].charAt(j) != base) {

                    same = false;
                    break;// 2번째 문자열과의 비교에서 !=을 찾는다면, 
                    		//세번째 문자열까지의 비교까지 가지 않겠다는 말이다. 
                    		//애초에 문자열 탐색을 새로로 돌고 있었다.
                }
            }

            if (same) sb.append(base);
            else sb.append('?');
        }

        System.out.println(sb);
    }
}