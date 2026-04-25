class Solution {
    // N, S, W, E 순서
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        
        int x = 0, y = 0;
        
        // 시작 위치 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for (String r : routes) {
            String[] parts = r.split(" ");
            String dir = parts[0];
            int dist = Integer.parseInt(parts[1]);
            
            int d = 0;
            if (dir.equals("N")) d = 0;
            else if (dir.equals("S")) d = 1;
            else if (dir.equals("W")) d = 2;
            else if (dir.equals("E")) d = 3;
            
            int nx = x;
            int ny = y;
            boolean ok = true;
            
            // 한 칸씩 이동 체크
            for (int i = 0; i < dist; i++) {
                nx += dx[d];
                ny += dy[d];
                
                if (nx < 0 || ny < 0 || nx >= h || ny >= w 
                    || park[nx].charAt(ny) == 'X') {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[]{x, y};
    }
}