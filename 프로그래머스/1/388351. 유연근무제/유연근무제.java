class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i< schedules.length; i++){
            
            boolean flag = true;
            int limit = schedules[i];

            int hour = limit / 100;
            int minute = limit % 100;
            
            minute += 10;

            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }

            limit = hour * 100 + minute;
            
            for (int j = 0; j < 7; j++) {
                int day = (startday - 1 + j) % 7;

                if (day == 5 || day == 6) {
                    continue;
                }
                if (timelogs[i][j] > limit) {
                    flag = false;
                    break;
                }
                
            }if(flag){
                answer++;
            }
            
        }
        
        return answer;
    }
}