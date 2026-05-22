import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        HashMap<Integer, Double>map = new HashMap<>();
        
        for(int i = 1; i<= N; i++){
            int mo = 0;
            int ja = 0;
            
            for(int x = 0; x <stages.length; x++){

                if(stages[x]>= i){
                    mo++;
                }
                if(stages[x]== i){
                    ja++;
                }
            }
            double f = 0;

            //분모가 0이 아닐때는 매우중요한 나누기 조건.
            if (mo != 0) {
                f = (double) ja / mo;
            }

            map.put(i, f);
        }
        
        //정렬하기
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b)->{
           if(map.get(b).equals(map.get(a))){
               return a - b;
           } 
            
            return Double.compare(map.get(b), map.get(a));
        });
        
        for(int i = 0; i<N; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}