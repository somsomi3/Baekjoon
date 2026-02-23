import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int count = 0;

        //N이 15일 경우, N에서 시작할 수도 있다. 그래서 left가 N까지는 가야한다
        //시작점이 N까지는 가야 해.
        
        //right는 끝점이고
//        끝점은 N을 넘으면 더 이상 확장할 수 없지만

//        left는 아직 이동하면서
//        남은 구간을 줄여가며 확인해야 해.  => 이거 전에 어떤 문제에서도 봤던거 같다...
        while (left <= N) {
            if (sum == N) {
                count++;
                sum -= left;
                left++;
            } 
            else if (sum < N) {
                right++;
                if (right > N) break;//"sum < N인데", right > N이면 더이상 sum을 크게 만들수 없다. 
                sum += right;
            } 
            else {
                sum -= left;
                left++;
            }
        }

        System.out.println(count);
    }
}