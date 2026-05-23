import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        
        String s = "";
        
        for(int i = 0; i<x; i++){
			s += "#";
        }        
        System.out.println(s);
	}
}