import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소 {
    static boolean[][] visited;
    static int max = 0;
    static int[][] map;
    static int[] toX = {0,0,-1,1};
    static int[] toY = {1,-1,0,0};
    static boolean[][] virusVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        virusVisited = new boolean[n][m];
        map = new int[n][m];

        for(int i=0;i<n;i++){
            st  = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(max);
    }

    public static void dfs(int depth, int startY){
        if(depth == 3){
           max = Math.max(max, checkSafeCnt());
           return;
        }

        for(int i=startY;i<map.length;i++){
            for(int j = 0;j<map[0].length;j++){
                if(!visited[i][j] && map[i][j] == 0){
                    visited[i][j] = true;
                    map[i][j] = 1;
                    dfs(depth+1,i);
                    map[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static int checkSafeCnt(){
        int[][] copy = new int[map.length][map[0].length];
        virusVisited = new boolean[map.length][map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                copy[i][j] = map[i][j];
            }
        }
        for(int i =0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] == 2 && !virusVisited[i][j]){
                    virusVisited[i][j] = true;
                    virus(copy,i,j);
                }
            }
        }
        int cnt = 0;
        for(int i = 0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(copy[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void virus(int[][] copy, int nowY, int nowX){
        for(int i=0;i<4;i++){
            int nextY = nowY + toY[i];
            int nextX = nowX + toX[i];

            if(nextY >= 0 && nextY < copy.length && nextX >= 0 && nextX < copy[0].length
            && copy[nextY][nextX] != 1 && !virusVisited[nextY][nextX]){
                copy[nextY][nextX] = 2;
                virusVisited[nextY][nextX] = true;
                virus(copy, nextY, nextX);
            }
        }
    }

}
