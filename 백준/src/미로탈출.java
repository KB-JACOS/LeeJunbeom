import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;



public class 미로탈출 {
    public static void main(String[] args) throws IOException {
        Solution13 solution = new Solution13();
        solution.solution(new String[] {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"});
    }
}

class Solution13 {
    public int solution(String[] maps) {
        int[] toX = {0,0,1,-1};
        int[] toY = {-1,1,0,0};
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)=='S'){
                    start[0]=i;
                    start[1]=j;
                }
                if(maps[i].charAt(j)=='E'){
                    end[0]=i;
                    end[1]=j;
                }
                if(maps[i].charAt(j)=='L'){
                    lever[0]=i;
                    lever[1]=j;
                }
            }
        }

        int toLeverCnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int nowY = cur[0];
            int nowX = cur[1];

            if(nowY == lever[0] && nowX == lever[1]){
                toLeverCnt = cur[2];
                break;
            }

            for(int i=0;i<4;i++){
                int nextY = nowY + toY[i];
                int nextX = nowX + toX[i];

                if(nextY >= 0 && nextY < maps.length && nextX >= 0 && nextX < maps[0].length() && maps[nextY].charAt(nextX) !='X'
                        && !visited[nextY][nextX]){
                    queue.add(new int[] {nextY, nextX, cur[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }

        if(toLeverCnt == 0){
            return -1;
        }
        queue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length()];
        queue.add(new int[] {lever[0], lever[1], toLeverCnt});
        visited[lever[0]][lever[1]] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int nowY = cur[0];
            int nowX = cur[1];

            if(nowY == end[0] && nowX == end[1]){
                return cur[2];
            }

            for(int i=0;i<4;i++){
                int nextY = nowY + toY[i];
                int nextX = nowX + toX[i];

                if(nextY >= 0 && nextY < maps.length && nextX >= 0 && nextX < maps[0].length() && maps[nextY].charAt(nextX) !='X'
                        && !visited[nextY][nextX]){
                    queue.add(new int[] {nextY, nextX, cur[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }

        return -1;
    }
}


