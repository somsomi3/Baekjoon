class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end =  0;
        
        for(int x: section){
            if(end< x){
                answer++;
                end = x + m -1;
            }
        }
        
        return answer;
    }
}