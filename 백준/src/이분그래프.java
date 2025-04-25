import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 이분그래프 {

    public static void main(String[] args) throws IOException {
        Solution12 solution = new Solution12();
        System.out.println(solution.isBipartite(new int[][] {{1}, {0,3}, {3}, {1,2}}));
    }

    static class Solution12 {
        static int[] visited;
        static boolean check;
        static int[][] outGraph;
        public boolean isBipartite(int[][] graph) {
            visited = new int[graph.length];
            check = true;
            outGraph = graph;

            for(int i = 0; i < graph.length; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                }
                dfs(i, graph[i]);
            }
            return check;
        }

        public void dfs(int now, int[] graph){
            if(!check){
                return;
            }
            int nowColor = visited[now];

            for (int i=0;i<graph.length;i++) {
                if(now != graph[i]) {
                    if (visited[graph[i]] == 0) {
                        if (nowColor == 1) {
                            visited[graph[i]] = 2;
                        } else {
                            visited[graph[i]] = 1;
                        }
                        dfs(graph[i], outGraph[graph[i]]);
                    } else {
                        if (visited[graph[i]] == nowColor) {
                            check = false;
                            return;
                        }
                    }
                }
            }
        }
    }
}
