import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int unit = 10;
        while (N >= unit) {
        	//절반 더해서, 나머지 없애서, 10단위 올려버리기
            N = ((N + unit / 2) / unit) * unit;
            //결과가 또 10단위로 큰지를 while에서 비교하기 위해서 기준*10해준다.
            unit *= 10;
        }

        System.out.println(N);
    }
}
