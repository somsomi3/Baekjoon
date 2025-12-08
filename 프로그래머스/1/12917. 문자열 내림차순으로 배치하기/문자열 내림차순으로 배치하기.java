import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        
//         int len = s.length();
//         Integer[] arr = new Integer[len];
//         for(int i=0; i<len; i++){
//             int x = s.charAt(i)-'0';
//             arr[i]= x;
//         }
        
//         Arrays.sort(arr, Collections.sort);
        
//         for(int i=0; i<len; i++){
//             sb.append((char)arr[i]);
//         }
//         // String answer = "";
//         return sb.toString;
//     }
// }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);        
        return new StringBuilder(new String(arr)).reverse().toString();
    }
}