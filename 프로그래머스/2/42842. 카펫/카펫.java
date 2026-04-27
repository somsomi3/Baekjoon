class Solution {
    public int[] solution(int brown, int yellow) {
                
        int[] answer = {};
        
        int sum = brown+ yellow;
        int x;
        int y;
        
        for(int i = 1; i<= sum; i++){
            if(sum%i==0){
                x = i;
                y = sum/i;
                if((x-2)*(y-2)== yellow){
                    return new int[]{y, x};
                }
                
            }
        }

        return answer;
    }
}