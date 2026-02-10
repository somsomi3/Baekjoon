import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[B + 1];

        int idx = 1;//채워야할 위치
        int num = 1;//현재 채울 숫자

        while (idx <= B) {
        	
        	//숫자 num을 num번 반복하기 위한 반복문
            for (int i = 0; i < num && idx <= B; i++) {//for중간에 idx제한을 위해서도 idx<=8이 필요하다.
                arr[idx] = num;//num을 num번 반복하기 위해 =num으로 써서 고정한다.
                idx++;//다음 위치로 이동
            }
            num++;//다음 숫자로 증가
        }

        int sum = 0;
        //출력을 위해
        for (int i = A; i <= B; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}