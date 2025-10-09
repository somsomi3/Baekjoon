import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);
        

        Set<Integer> overlap = new HashSet<>(lostSet);
        overlap.retainAll(reserveSet);
        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);
        
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) lostSet.remove(r - 1);
            else if (lostSet.contains(r + 1)) lostSet.remove(r + 1);
        }
        return n - lostSet.size();
    }
}
