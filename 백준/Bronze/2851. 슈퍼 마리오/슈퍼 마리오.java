import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//백설공주와 난쟁이랑 유사하지만, 백설공주와 난쟁이가 좀더 어려운 듯 함.		
		//총10개 주어짐.		
		int sum =0;
		for(int i=0; i<10; i++) {
			int x = Integer.parseInt(br.readLine());
            int prev = sum;   // 먹기 전 점수
			sum += x;

			if(sum>=100) {
                // 100과의 거리 비교
                int diffAfter = sum - 100;
                int diffBefore = 100 - prev;

                if (diffAfter > diffBefore) {
                    sum = prev;
                }
                break;
			}
		}
		System.out.println(sum);
	}
}