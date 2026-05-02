class Solution {
    
    public int solution(int n) {
        int target = countOne(n);
        
        while (true) {
            n++;
            if (countOne(n) == target) {
                return n;
            }
        }
    }
    
    public int countOne(int n) {
        int cnt = 0;
        
        while (n > 0) {
            if (n % 2 == 1) cnt++;
            n /= 2;
        }
        
        return cnt;
    }
}