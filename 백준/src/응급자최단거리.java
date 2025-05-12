import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;



public class 응급자최단거리 {
    public static void main(String[] args) throws IOException {
        Solution12 solution = new Solution12();
        solution.solution(new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}, {0,0,0,0}});
    }
}

class Solution12 {
    public int solution(int[][] city) {
        int rows = city.length;
        int cols = city[0].length;

        if (city[0][0] == 1 || city[rows - 1][cols - 1] == 1) {
            return -1;
        }

        int[] toY = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] toX = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        city[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            int depth = now[2];

            if (nowY == rows - 1 && nowX == cols - 1) {
                return depth;
            }

            for (int i = 0; i < 8; i++) {
                int nextY = nowY + toY[i];
                int nextX = nowX + toX[i];

                if (nextY >= 0 && nextY < rows && nextX >= 0 && nextX < cols && city[nextY][nextX] == 0) {
                    city[nextY][nextX] = 1;
                    queue.offer(new int[]{nextY, nextX, depth + 1});
                }
            }
        }

        return -1;
    }
}


