class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        for(int i = 1; i<= n; i++){
            int cnt = 0;
            for(int j = 0; j <n; j++){
                if(citations[j]>=i){
                    cnt++;
                }
            }

            if (cnt >= i) {
                answer = i;

            }
        }
        
        return answer;
    }
}