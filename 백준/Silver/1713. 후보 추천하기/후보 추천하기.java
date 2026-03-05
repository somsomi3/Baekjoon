import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        int num;
        int vote;
        int time;

        Student(int num, int vote, int time) {
            this.num = num;
            this.vote = vote;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Student> frame = new ArrayList<>();

        //입력 카운트 마다. 총 M회
        for(int cnt = 0; cnt < M; cnt++) {
            int x = Integer.parseInt(st.nextToken());
            boolean found = false;

            //사진들에 있는 경우
            for(Student s : frame) {
                if(s.num == x) {//사진틀에 이미 있다면,
                    s.vote++;
                    found = true;
                    break;
                }
            }

            if(found) continue;//이미 사진틀에 있다면, 다음 추천으로 넘어감 위에 for문도는곳으로 간다.

            //사진틀에 없어서 새로 넣어야하는 경우
            
            if(frame.size() < N) {//사진틀에 자리가 있다면
                frame.add(new Student(x, 1, cnt));
            } 
            else {//사진틀에 자리가 없다면
                Student remove = frame.get(0);//첫 번째 학생을 제거 후보로 설정
                for(Student s : frame) {
                    if(s.vote < remove.vote) remove = s;// 추천수가 더 적으면, 적은애로 후보를 변경한다.
                    else if(s.vote == remove.vote && s.time < remove.time) remove = s;//추천수가 같으면, 더 오래된 학생 제거
                }
                //제거
                frame.remove(remove);
                //제거하고 빈자리에 새학생 추가
                frame.add(new Student(x, 1, cnt));
            }
        }

        List<Integer> result = new ArrayList<>();
        for(Student s : frame) result.add(s.num);

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for(int x : result) sb.append(x).append(" ");

        System.out.println(sb);
    }
}