import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;



public class 거리두기확인하기 {
    public static void main(String[] args) throws IOException {
        Solution14 solution = new Solution14();
        solution.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }
}

class Solution14 {
    static boolean[][] visited;
    static int[] toY = {0,0,1,-1};
    static int[] toX = {1,-1,0,0};
    static boolean check;
    public int[] solution(String[][] places) {

        int[] result = new int[places.length];
        int resultFlag = 0;

        for(int i=0;i<places.length;i++){
            visited = new boolean[places[i].length][places[i][0].length()];
            check = true;
            for(int j=0;j<places[i].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    if(places[i][j].charAt(k)=='P'){
                        visited[j][k] = true;
                        dfs(j,k,j,k,places[i]);
                        visited = new boolean[places[i].length][places[i][0].length()];
                    }
                }
            }
            if(check){
                result[resultFlag++] = 1;
            }
            else{
                result[resultFlag++] = 0;
            }
        }
        return result;
    }

    public static void dfs(int starti, int startj, int nowi, int nowj, String[] places){
        for(int i=0;i<4;i++){
            int nexti = nowi + toY[i];
            int nextj = nowj + toX[i];

            if (nexti >= 0 && nexti < places.length &&
                    nextj >= 0 && nextj < places[0].length() &&
                    !visited[nexti][nextj] &&
                    places[nexti].charAt(nextj) != 'X' &&
                    Math.abs(starti - nexti) + Math.abs(startj - nextj) <= 2){

                visited[nexti][nextj] = true;
                if(places[nexti].charAt(nextj) == 'P'){
                    check = false;
                    return;
                }
                dfs(starti, startj, nexti, nextj, places);
            }
        }
    }
}


