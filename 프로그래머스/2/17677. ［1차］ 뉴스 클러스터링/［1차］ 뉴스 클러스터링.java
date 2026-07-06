import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> strMap1 = new HashMap<>();
        Map<String, Integer> strMap2 = new HashMap<>();
        
        //다 대문자로 만들어주기
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        //다 문자인지 확인하고, 2개씩 끊어서 map에 저장하기
        int startStr1 = 0;
        int endStr1 =2;
        
        while(endStr1<= str1.length()){
            
            StringBuilder sb = new StringBuilder();
            
            //문자인지 아닌지 boolean 플래그
            boolean isValid = true;
            for(int i = startStr1; i<endStr1; i++){
                char c = str1.charAt(i);
                
                if (Character.isLetter(c)) {
                    sb.append(c);
                }else{
                    isValid = false;
                    break;
                }
            }
            
            if(isValid){
                String key = sb.toString();
                strMap1.put(key, strMap1.getOrDefault(key, 0) + 1);
            }

            startStr1++;
            endStr1++;
        }
        
        //str2도 동일
        int startStr2 =0;
        int endStr2 = 2;
        
        while (endStr2 <= str2.length()) {
            StringBuilder sb = new StringBuilder();

            boolean isValid = true;
            for (int i = startStr2; i < endStr2; i++) {
                char c = str2.charAt(i);

                if (Character.isLetter(c)) {
                    sb.append(c);
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                String key = sb.toString();
                strMap2.put(key, strMap2.getOrDefault(key, 0) + 1);
            }

            startStr2++;
            endStr2++;
        }
        
        //둘다 돌면서 map의 max와 min을 구하기
        
        int intersection = 0;
        int union = 0;
        
        Set<String> keys = new HashSet<>();
        
        //모든문자열 모으기
        keys.addAll(strMap1.keySet());
        keys.addAll(strMap2.keySet());

        for (String key : keys) {
            int cnt1 = strMap1.getOrDefault(key, 0);
            int cnt2 = strMap2.getOrDefault(key, 0);

            intersection += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);
        }

        if (union == 0) {
            return 65536;
        }

        return intersection * 65536 / union;
    }
}
