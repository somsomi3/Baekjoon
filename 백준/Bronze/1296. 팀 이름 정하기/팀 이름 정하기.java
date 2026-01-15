import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int baseL = 0, baseO = 0, baseV = 0, baseE = 0;
        for (char c : name.toCharArray()) {
            if (c == 'L') baseL++;
            else if (c == 'O') baseO++;
            else if (c == 'V') baseV++;
            else if (c == 'E') baseE++;
        }

        int N = Integer.parseInt(br.readLine());

        String answer = "";
        int maxScore = -1;

        for (int i = 0; i < N; i++) {
            String team = br.readLine();

            int l = baseL, o = baseO, v = baseV, e = baseE;

            for (char c : team.toCharArray()) {
                if (c == 'L') l++;
                else if (c == 'O') o++;
                else if (c == 'V') v++;
                else if (c == 'E') e++;
            }

            int score = ((l + o) * (l + v) * (l + e)
                       * (o + v) * (o + e) * (v + e)) % 100;

            if (score > maxScore || (score == maxScore && team.compareTo(answer) < 0)) {
                maxScore = score;
                answer = team;
            }
        }

        System.out.println(answer);
    }
}