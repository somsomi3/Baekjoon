import java.util.Scanner;
import java.util.HashSet;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] arr = new int[9][9];

			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}

			int answer = 1;

			// 가로 검사
			for(int i = 0; i < 9 && answer == 1; i++){
				HashSet<Integer> set = new HashSet<>();
				for(int j = 0; j < 9; j++){
					if(set.contains(arr[i][j])){
						answer = 0;
						break;
					}
					set.add(arr[i][j]);
				}
			}

			// 세로 검사
			for(int j = 0; j < 9 && answer == 1; j++){
				HashSet<Integer> set = new HashSet<>();
				for(int i = 0; i < 9; i++){
					if(set.contains(arr[i][j])){
						answer = 0;
						break;
					}
					set.add(arr[i][j]);
				}
			}

			// 3×3 검사
            //2개는 "박스 선택", 2개는 "박스 내부 탐색"
			for(int r = 0; r < 9 && answer == 1; r += 3){
				for(int c = 0; c < 9 && answer == 1; c += 3){
					HashSet<Integer> set = new HashSet<>();
					for(int i = r; i < r + 3; i++){
						for(int j = c; j < c + 3; j++){
							if(set.contains(arr[i][j])){
								answer = 0;
								break;
							}
							set.add(arr[i][j]);
						}

						if(answer == 0){
							break;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}