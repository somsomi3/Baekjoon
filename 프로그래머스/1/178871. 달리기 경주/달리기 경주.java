import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i< players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i = 0; i< callings.length; i++){
            
            int x = map.get(callings[i]);
            String front = players[x -1];
            
            //위치 바꾸기
            players[x - 1] = callings[i];
            players[x] = front;
            
            map.put(callings[i], map.get(callings[i])-1);
            map.put(front, map.get(front) + 1);
            
        }
        
        
        return players;
    }
}