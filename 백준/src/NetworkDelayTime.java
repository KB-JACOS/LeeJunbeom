import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.w3c.dom.Node;

public class NetworkDelayTime {
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<node>> map = new HashMap<>();
            for(int i=0;i<=n;i++){
                map.put(i,new ArrayList<node>());
            }
            for (int i = 0; i < times.length; i++) {
                for (int j = 0; j < times[i].length; j++) {
                    map.get(times[i][0]).add(new node(times[i][1], times[i][2]));
                }
            }

            Queue<node> pq = new PriorityQueue<>();
            int[] delay = new int[n+1];
            Arrays.fill(delay, Integer.MAX_VALUE);
            pq.offer(new node(k,0));
            delay[k] = 0;
            delay[0] = 0;

            while (!pq.isEmpty()) {
                node now = pq.poll();
                int nowIdx = now.target;
                int nowDistance = now.distance;

                if(delay[nowIdx] < nowDistance) continue;

                List<node> nodes = map.get(nowIdx);
                if(nodes == null) continue;
                for (node toNode : nodes) {
                    if(delay[toNode.target] > toNode.distance + nowDistance) {
                        pq.offer(new node(toNode.target, toNode.distance + nowDistance));
                        delay[toNode.target] = toNode.distance + nowDistance;
                    }
                }
            }
            int max = 0;
            for (int i : delay) {
                if(i == Integer.MAX_VALUE) return -1;
                max = Math.max(max, i);
            }
            return max;
        }
    }

    public class node implements Comparable<node> {
        public int target;
        public int distance;

        node(int target, int distance){
            this.target = target;
            this.distance = distance;
        }

        @Override
        public int compareTo(node o) {
            return this.distance - o.distance;
        }
    }
}
