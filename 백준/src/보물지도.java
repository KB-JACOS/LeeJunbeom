import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 보물지도 {
    public static void main(String[] args) throws IOException {
        Solution15 solution = new Solution15();
//        solution.solution(4,4,new int[][]{{2,3}, {3,3}}
//        );
    }
}

class Solution15 {
    static int[] toX = {0,0,1,-1};
    static int[] toY = {1,-1,0,0};
    static boolean visited[][][];
    class Solution {
        static int[] toX = {0,0,1,-1};
        static int[] toY = {1,-1,0,0};
        static boolean visited[][][];
        public int solution(int n, int m, int[][] hole) {
            int[][] map = new int[m][n];
            visited = new boolean[m][n][2];
            for (int[] h : hole) {
                map[h[1]-1][h[0]-1] = 1;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0,0,0});
            visited[0][0][0] = true;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int nowY = poll[0];
                int nowX = poll[1];
                int dist = poll[2];
                int usingShoe = poll[3];

                if(nowY == m-1 && nowX == n-1){
                    return dist;
                }

                for(int i=0;i<4;i++){
                    int nextY = nowY+toY[i];
                    int nextX = nowX+toX[i];
                    int nextMagicY = nowY+toY[i] * 2;
                    int nextMagicX = nowX+toX[i] * 2;

                    if(nextY >= 0 && nextY < m
                            && nextX >= 0 && nextX < n
                            && map[nextY][nextX] == 0
                            && !visited[nextY][nextX][usingShoe]) {
                        visited[nextY][nextX][usingShoe] = true;
                        queue.offer(new int[]{nextY, nextX, dist + 1, usingShoe});
                    }

                    if(usingShoe == 0){
                        if(nextMagicY >= 0 && nextMagicY < m
                                && nextMagicX >= 0 && nextMagicX < n
                                && map[nextMagicY][nextMagicX] == 0
                                && !visited[nextMagicY][nextMagicX][1]) {
                            visited[nextMagicY][nextMagicX][1] = true;
                            queue.offer(new int[]{nextMagicY, nextMagicX, dist + 1, 1});
                        }
                    }
                }
            }
            return -1;
        }
    }
}
