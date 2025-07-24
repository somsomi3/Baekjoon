import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        Integer[] crane = new Integer[N];
        for (int i = 0; i < N; i++) {
            crane[i] = sc.nextInt();
        }

        int M = sc.nextInt(); 
        Integer[] box = new Integer[M];
        for (int i = 0; i < M; i++) {
            box[i] = sc.nextInt();
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());

        if (box[0] > crane[0]) {
            System.out.println(-1); 
            return;
        }

        boolean[] moved = new boolean[M]; // 박스 옮겼는지 여부
        int time = 0;
        int movedCount = 0;

        while (movedCount < M) {
            int boxIdx = 0;

            for (int i = 0; i < N; i++) { // 각 크레인에 대해
                while (boxIdx < M) {
                    if (!moved[boxIdx] && crane[i] >= box[boxIdx]) {
                        moved[boxIdx] = true;
                        movedCount++;
                        boxIdx++;
                        break;
                    }
                    boxIdx++;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}
