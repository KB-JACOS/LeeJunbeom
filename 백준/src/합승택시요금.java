import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 합승택시요금 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6,4,6,2,new int[][] {{4,1,10}, {3,5,24},{5,6,2}, {3,1,41}, {5,1,24}, {4,6,50}, {2,4,66}, {2,3,22}, {1,6,25}});
    }
    static class Solution {
        static Map<Integer, List<node>> map;
        public int solution(int n, int s, int a, int b, int[][] fares) {
            map = new HashMap<>();
            for(int i=1;i<=n;i++){
                map.put(i, new ArrayList<node>());
            }

            for(int i=0;i<fares.length;i++){
                map.get(fares[i][0]).add(new node(fares[i][1],fares[i][2]));
                map.get(fares[i][1]).add(new node(fares[i][0],fares[i][2]));
            }
            int min = Integer.MAX_VALUE;

            int[][] dist = new int[3][n+1];
            Arrays.fill(dist[0],Integer.MAX_VALUE);
            Arrays.fill(dist[1],Integer.MAX_VALUE);
            Arrays.fill(dist[2],Integer.MAX_VALUE);

            dist[0] = dijkstra(s,n,n);
            dist[1] = dijkstra(a,n,n);
            dist[2] = dijkstra(b,n,n);


            for(int i=1;i<=n;i++){
                int end = i;
                min = Math.min(min,dist[0][end] + dist[1][end] + dist[2][end]);
            }
            return min;
        }

        public int[] dijkstra(int start, int end, int n){
            Queue<node> pq = new PriorityQueue<>();
            int[] dist = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);

            dist[start] = 0;
            pq.add(new node(start,0));
            while(!pq.isEmpty()){
                node cur = pq.poll();
                int nowIdx = cur.index;
                int nowDist = cur.cost;

                if(nowDist > dist[nowIdx]) continue;

                List<node> nodes = map.get(nowIdx);
                for(node nextNode : nodes){
                    if(dist[nextNode.index] > nowDist + nextNode.cost){
                        dist[nextNode.index] = nowDist + nextNode.cost;
                        pq.add(new node(nextNode.index,nowDist + nextNode.cost));
                    }
                }
            }

            return dist;
        }

        public class node implements Comparable<node> {
            int index;
            int cost;

            public node(int index, int cost) {
                this.index = index;
                this.cost = cost;
            }
            @Override
            public int compareTo(node o){
                return cost - o.cost;
            }
        }
    }
}
