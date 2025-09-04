import java.util.ArrayList;
import java.util.List;

public class 단어찾기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.exist(new char[][] {{'a','a','A','a','a','a'},{'a','a','a','a','A','a'},{'a','a','a','a','A','A'},{'A','A','a','A','a','A'},{'a','a','a','a','A','a'},{'A','a','a','A','a','a'}}, "aAAaAaaaAaAaAAA");
    }

    static class Solution {
        static int[] toX = {1,-1,0,0};
        static int[] toY = {0,0,1,-1};
        static boolean[][] visited;
        static char[][] board2;
        static String word2;
        static boolean flag;
        static StringBuilder sb;
        public boolean exist(char[][] board, String word) {
            board2 = board;
            word2 = word;
            flag = false;
            for(int i=0;i<board2.length;i++){
                for(int j=0;j<board2[0].length;j++){
                    List<String> l = new ArrayList<String>();
                    visited = new boolean[board2.length][board2[0].length];
                    sb = new StringBuilder();
                    sb.append(board[i][j]);
                    visited[i][j] = true;
                    dfs(j,i);
                    if(flag){
                        return true;
                    }
                }
            }
            return false;
        }

        public void dfs(int nowX, int nowY){
            if(flag){
                return;
            }

            if(sb.length() == word2.length()) {
                if(word2.equals(sb.toString())) {
                    flag = true;
                }
                return;
            }


            for(int i=0;i<4;i++){
                int nextY = nowY + toY[i];
                int nextX = nowX + toX[i];

                if(nextY >= 0 && nextY < board2.length &&
                nextX >= 0 && nextX < board2[0].length
                && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    sb.append(board2[nextY][nextX]);
                    dfs(nextX, nextY);
                    visited[nextY][nextX] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}
