class Solution {
    public int solution(int[] absolutes, boolean[] signs) {

        for(int i =0; i<signs.length; i++){
            if( signs[i] ==false)
                absolutes[i]= -absolutes[i];
        }
        int sum =0;
        for(int i =0; i<signs.length; i++){
            sum += absolutes[i];
        }
        
        return sum;
    }
}