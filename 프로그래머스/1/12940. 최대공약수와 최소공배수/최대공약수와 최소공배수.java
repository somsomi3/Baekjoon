class Solution {

    static int gcd(int n, int m){
        while (m > 0) {
                    int r = n % m;
                    n = m;
                    m = r;
                }
                return n;
            }
    
    static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }
    public int[] solution(int n, int m) {
        int g = gcd(n, m);
        int l = lcm(n, m);

        return new int[]{g, l};
    }
}