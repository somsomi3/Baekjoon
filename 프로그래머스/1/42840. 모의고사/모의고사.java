import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int arr1Cnt = 0;
        int arr2Cnt = 0;
        int arr3Cnt = 0;
        
        for(int i = 0; i<answers.length; i++){
            if(arr1[i%5]==answers[i])arr1Cnt++;
            if(arr2[i%8]==answers[i])arr2Cnt++;
            if(arr3[i%10]==answers[i])arr3Cnt++;
        }
        int[] momo = new int[3];
        momo[0]= arr1Cnt;
        momo[1]= arr2Cnt;
        momo[2]= arr3Cnt;
        
        int max = Math.max(arr1Cnt, Math.max(arr2Cnt, arr3Cnt));
        
        int cnt = 0;
        for(int i= 0; i < momo.length; i++){
            if(momo[i]>=max)cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;

        if(arr1Cnt == max) answer[idx++] = 1;
        if(arr2Cnt == max) answer[idx++] = 2;
        if(arr3Cnt == max) answer[idx++] = 3;

        return answer;
    }
}