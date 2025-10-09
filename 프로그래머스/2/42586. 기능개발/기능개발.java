import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int n = progresses.length;
        int[] cai = new int[n];
        for(int i=0; i<n; i++){
            // cai[i]= (100-progresses[i])/speeds[i];
            cai[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        for(int i=1; i<n; i++){
        //     if (cai[i]> cai[i+1]){
        //         cai[i+1]= cai[i];
        //     }
        // }
            if(cai[i] < cai[i - 1]){
                cai[i] = cai[i - 1];
            }
        }
  
        List<Integer> list = new ArrayList<>();
        int count =1;
        for(int i=1; i<n; i++){
            if(cai[i] == cai[i - 1]){
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}