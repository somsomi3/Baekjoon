import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String[]> list = new ArrayList<>();//문자열 배열 여러 개 저장
        HashMap<String, String> map = new HashMap<>();
        
        for (String s : record) {
            
            String[] arr = s.split(" ");//방법 번호 이름
            
            //세가지로 나눠진 배열 arr을 만들어 놓고, list에 넣어라...
            list.add(arr);
            
            if(arr[0].equals("Enter") || arr[0].equals("Change")){
                map.put(arr[1], arr[2]);//번호와 이름
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String[] arr : list) {
            String uid = arr[1];// arr에서 번호 가져와
            String nickname = map.get(uid); //번호를 통해서 이름 가져와
                    if (arr[0].equals("Enter")) {
                result.add(nickname + "님이 들어왔습니다.");
            }

            else if (arr[0].equals("Leave")) {
                result.add(nickname + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
    }
}