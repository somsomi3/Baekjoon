import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            if(score > max){
                max = score;
            }
        }

        double result = 0;
        for(int i = 0; i < N; i++) {
            result += (double)scores[i] / max * 100;
        }
        result /= N;
        System.out.println(result);
    }
}