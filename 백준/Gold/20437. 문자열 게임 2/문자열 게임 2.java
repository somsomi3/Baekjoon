import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());

        while (testCount-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            //각 알파벳(a~z)의 등장 위치 리스트
            ArrayList<Integer>[] charIndices = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                charIndices[i] = new ArrayList<>();
            }

            //문자별 등장 위치 기록
            for (int index = 0; index < str.length(); index++) {
                int ch = str.charAt(index) - 'a';
                charIndices[ch].add(index);
            }

            int shortestLength = Integer.MAX_VALUE;
            int longestLength = -1;

            //각 문자(a~z)에 대하여
            for (int ch = 0; ch < 26; ch++) {
                List<Integer> indices = charIndices[ch];

                //등장 횟수가 K보다 적으면 불가능
                if (indices.size() < k) continue;

                //K개 연속 구간 찾기
                for (int left = 0; left + k - 1 < indices.size(); left++) {
                    int right = left + k - 1;

                    int startPos = indices.get(left);
                    int endPos = indices.get(right);

                    int substringLength = endPos - startPos + 1;

                    shortestLength = Math.min(shortestLength, substringLength);
                    longestLength = Math.max(longestLength, substringLength);
                }
            }

            if (longestLength == -1) {
                System.out.println(-1);
            } else {
                System.out.println(shortestLength + " " + longestLength);
            }
        }
    }
}
