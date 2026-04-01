import java.io.*;
import java.util.*;

class Solution {
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!= rootB){
            parent[rootB] = rootA;
            }
        }

        static int find(int x){
            if(parent[x]==x)return x;
            return parent[x] = find(parent[x]);
        }
        static int[] parent;

        static boolean[] visited;
        public int solution(int n, int[][] computers) {


            parent = new int[n+1];
            for(int i = 1; i<=n; i++)parent[i] = i;

            visited = new boolean[n+1];

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(computers[i][j]==1){
                    if(find(i)!= find(j)){
                        union(i, j);
                        }
                    }
                }
            }
            int x = find(1);

            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                set.add(find(i));
            }

            return set.size();
        }
    }