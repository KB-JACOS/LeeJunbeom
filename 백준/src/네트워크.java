
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class 네트워크 {
    public static void main(String[] args) throws IOException {
        Solution7 solution = new Solution7();
        solution.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public static class Solution7 {
        static int cnt;
        static boolean visited[];
        public int solution(int n, int[][] computers) {
            visited = new boolean[n];

            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(computers, i);
                    cnt++;
                }
            }
            return cnt;
        }

        public void dfs(int[][] computers, int now){

            for(int i=0;i<computers[now].length;i++){
                if(!visited[i] && i != now && computers[now][i] == 1){
                    visited[i] = true;
                    dfs(computers, i);
                }
            }
        }
    }
}

