import java.io.*;
import java.util.*;

public class Main {
	static class Student{
		int num, cnt, time;
		
		Student(int num, int count, int time){
			this.num = num;
			this.cnt = cnt;
			this.time = time;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Student> frame = new ArrayList<>();
		
		int time = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			//입력
			int x = Integer.parseInt(st.nextToken());
			time++;
			
			boolean flag = false;
			
			for(Student s: frame) {
				if(s.num== x) {
					s.cnt++;
					flag = true;
					break;
				}
			}
			
			//사진이 사진 틀에 없다면,
			if(!flag) {
				if(frame.size()<N) {
					frame.add(new Student(x, 1, time));
				}else {//사진 틀이 꽉차있다면
					Collections.sort(frame, (a, b)->{
						if(a.cnt != b.cnt)
							return a.cnt - b.cnt;
						return a.time -b.time;
					});
					// 가장 앞 학생 제거
                    frame.remove(0);

                    // 새 학생 추가
                    frame.add(new Student(x, 1, time));
				}
			}
			
		}
		// 최종 출력은 학생 번호 오름차순
        Collections.sort(frame, (a, b) -> a.num - b.num);

        for (Student s : frame) {
            System.out.print(s.num + " ");
        }
    }
}