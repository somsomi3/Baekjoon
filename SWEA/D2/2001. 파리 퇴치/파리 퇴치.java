import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] arr = new int[n][n];

			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					arr[i][j] = sc.nextInt();
                }
            }
            
            int max = 0;
			for(int i = 0; i < n - m + 1; i++){
				for(int j = 0; j < n - m + 1; j++){
                 	int sum = 0;
					for(int x = i; x < i + m; x++){
						for(int y = j; y < j + m; y++){
                            sum+= arr[x][y];
                        }
                    }
                    max = Math.max(max, sum);
                }    
            }
            System.out.println("#" + test_case + " " + max);
		}
	}
}