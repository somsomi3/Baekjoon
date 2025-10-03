import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 입력을 분 단위로 변환해서 저장
        int n = book_time.length;
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = toMinute(book_time[i][0]); // 시작 시간
            times[i][1] = toMinute(book_time[i][1]) + 10; // 끝나는 시간 + 청소 10분
        }

        // 2. 시작 시간 기준 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 3. 우선순위큐: 끝나는 시간 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int start = times[i][0];
            int end = times[i][1];

            // 가장 빨리 끝나는 방이 이번 시작시간보다 작거나 같으면 재사용 가능
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            // 이번 예약의 끝나는 시간 추가
            pq.offer(end);

            // 현재 사용 중인 방 개수 = pq.size()
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    // 시각 "HH:MM" → 분 단위로 변환
    private int toMinute(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }
}
