
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class 가장먼노드 {
    public static void main(String[] args) throws IOException {
        Solution9 solution = new Solution9();
        solution.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    static class Solution9 {
        static boolean[] visited;
        static int max = 0;
        static int maxCount = 0;

        public int solution(int n, int[][] edge) {
            Queue<Integer> queue = new LinkedList<>();
            visited = new boolean[n+1];
            queue.offer(1);
            visited[1] = true;
            bfs(edge, queue, 0);
            return maxCount;
        }

        public void bfs(int[][] edges, Queue<Integer> queue, int depth) {
            Queue<Integer> newQueue = new LinkedList<>();
            if(max < depth){
                max = depth;
                maxCount = queue.size();
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int[] edge : edges) {
                    if(edge[0] == cur && !visited[edge[1]]) {
                        visited[edge[1]] = true;
                        newQueue.add(edge[1]);
                    }
                    else if(edge[1] == cur && !visited[edge[0]]) {
                        visited[edge[0]] = true;
                        newQueue.add(edge[0]);
                    }
                }
            }
            if(!newQueue.isEmpty()) {
                bfs(edges, newQueue, depth + 1);
            }
        }
    }
}


