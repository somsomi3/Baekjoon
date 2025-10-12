import java.util.*;

class Solution {
    public int solution(String s) {
        //해쉬맵 선언
        // HashMap<String, String> map = new HashMap<>();
        int n = s.length();
            
        Map<String, String> map = new LinkedHashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
//         System.out.println(map);
        
        // for(String key : map.keySet()){
        //     System.out.println(key +" " + map.get(key));
        // }
                
        // 2. 숫자인지 문자인지 판별하며 변환
        StringBuilder sb = new StringBuilder(); //출력할거 하나 만들고!
        String temp = "";
        

            
        for(char c: s.toCharArray()){
            // System.out.println(c);
            if(Character.isDigit(c)){
                sb.append(c);
            }else{//문자는 쌓아야해
                temp+=c;
                if(map.containsKey(temp)){
                    sb.append(map.get(temp));
                    temp = "";
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}