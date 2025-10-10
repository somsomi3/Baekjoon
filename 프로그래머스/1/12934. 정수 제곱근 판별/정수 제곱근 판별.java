import java.util.*;

class Solution {
    public long solution(long n) {
        long sqrt= (long)Math.sqrt(n);
        if (sqrt*sqrt==n)
            return (sqrt+1)*(sqrt+1);
        return -1;
    }
}


// import java.util.*;

// class Solution {
//     public long solution(long n) {
//        for (long i =1; i*i<=n; i++){
//            if(i*i==n){
//                 return (i+1)*(i+1);    
//            }
//        }
//         return -1;
//     }
// }