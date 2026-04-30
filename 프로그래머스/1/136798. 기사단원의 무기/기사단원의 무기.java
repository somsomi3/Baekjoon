class Solution {
    
    public int find(int x){
        int cnt = 0;
        
        for(int i = 1; i * i <= x; i++){
            if(x % i == 0){
                cnt++;
                if(i * i != x) cnt++;
            }
        }
        return cnt;
    }
    
    public int solution(int number, int limit, int power) {
        int sum = 0;
        
        for(int i = 1; i <= number; i++){
            int cnt = find(i);
            
            if(cnt > limit) cnt = power;
            sum += cnt;
        }
        
        return sum;
    }
}