import java.util.*;
class 태어난김에세계일주 {

    public static boolean[] visited;
    public static int max;

    public int solution(int balance, int[][] countries) {
        visited = new boolean[countries.length + 1];
        max=0;
        dfs(countries, balance, 0);
        return max;
    }

    public void dfs(int[][] countries, int balance, int depth){

        max = Math.max(max, depth);

        for(int i=0;i<countries.length;i++){
            if(!visited[i] && balance >= countries[i][1]){
                visited[i] = true;
                dfs(countries,balance - countries[i][0], depth+1);
                visited[i] = false;
            }
        }
    }
}