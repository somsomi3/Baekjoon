import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[j][moves[i] - 1] != 0) {

                    int doll = board[j][moves[i] - 1];
                    
                    board[j][moves[i] - 1] = 0;

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }

                    break;
                }
            }
        }

        return answer;
    }
}