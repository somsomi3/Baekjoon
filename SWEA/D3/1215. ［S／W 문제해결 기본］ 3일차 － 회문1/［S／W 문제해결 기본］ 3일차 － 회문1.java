import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++){
			int n = sc.nextInt();

			char[][] arr = new char[8][8];

			for(int i = 0; i < 8; i++){
				String s = sc.next();

				for(int j = 0; j < 8; j++){
					arr[i][j] = s.charAt(j);
				}
			}

			int cnt = 0;

			// 가로 검사
			for(int i = 0; i < 8; i++){
				for(int start = 0; start <= 8 - n; start++){
					boolean flag = true;

					for(int k = 0; k < n / 2; k++){
						if(arr[i][start + k] != arr[i][start + n - 1 - k]){
							flag = false;
							break;
						}
					}

					if(flag){
						cnt++;
					}
				}
			}

			// 세로 검사
			for(int j = 0; j < 8; j++){
				for(int start = 0; start <= 8 - n; start++){
					boolean flag = true;

					for(int k = 0; k < n / 2; k++){
						if(arr[start + k][j] != arr[start + n - 1 - k][j]){
							flag = false;
							break;
						}
					}

					if(flag){
						cnt++;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}