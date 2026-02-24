import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr= new int[N];
		for(int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		//음수
		int sum = 0;
		int i = 0;

		for(i = 0; i < N-1; i += 2) {
		    if(arr[i] < 0 && arr[i+1] < 0) {
		        sum += arr[i] * arr[i+1];
		    } else {
		        break;
		    }
		}
		
		
		//양수
		int j = N-1;

		for(j = N-1; j > i; j -= 2) {
		    if(arr[j] > 1 && arr[j-1] > 1) {
		        sum += arr[j] * arr[j-1];
		    } else {
		        break;
		    }
		}
		
		// 남은 값 처리
        for(int k = i; k <= j; k++) {
            if(arr[k] < 0) {
                // 남은 음수 하나
                if(k + 1 <= j && arr[k + 1] == 0) {
                    k++; // 0이랑 묶어서 제거
                } else {
                    sum += arr[k];
                    }
            } else {
                sum += arr[k];
            }
        }
		
        System.out.println(sum);
	}
}
