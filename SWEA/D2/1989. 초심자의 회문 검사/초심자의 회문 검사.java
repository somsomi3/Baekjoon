import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String s = sc.next();
            char[] arr = new char[s.length()];
            
            for(int i = 0; i<s.length(); i++){
            	arr[i] = s.charAt(i);
            }
            
            int i = 0; 
            int j = s.length() -1;
            
            boolean flag = true;
            while(i < j){
            //while(i != j)  //이건 홀수 길이에서 문제가 생길 수 있음.
                if(arr[i] == arr[j]){
                    i++;
                    j--;
                }else{
                    flag = false;
                    break;
                }
           }
                   
            if(flag){
                System.out.println("#" + test_case + " " + 1);
            }else{
                System.out.println("#" + test_case + " " + 0);
            }
		}
	}
}