//1. union find풀이
import java.io.*;
import java.util.*;

class Solution {
    static int[] parent;
    
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!= rootB) parent[rootB] = rootA;
    }
    static int find(int x){
        if(parent[x] ==x)return x;
        return parent[x] = find(parent[x]);
    }
    
    public int solution(int n, int[][] computers) {
        
        parent = new int[n];
        
        for(int i = 0; i< n; i++)parent[i] = i;
        
        for(int i = 0; i< n; i++){
            for(int j = i+1; j <n; j++){
                if(computers[i][j]==1){
                    union(i, j);
                }
            }
        }
        
        //같은 부모 = 같은 그룹
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i<n; i++){
            set.add(find(i));
        }
        
        int answer = set.size();
        return answer;
    }
}