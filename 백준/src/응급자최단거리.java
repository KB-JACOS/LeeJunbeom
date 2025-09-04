import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


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

        Set<String> a = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> b = new ArrayList<>();
        Integer[] aa = {1,2,3,4};



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


