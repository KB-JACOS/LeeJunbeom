import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumProbability {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProbability(3,new int[][] {{0,1}, {1,2}, {0,2}}, new double[] {0.5,0.5,0.2},0,2 ));
    }

    static class Solution {
        public class node implements Comparable<node> {
            int index;
            double probability;
            public node(int index, double probability){
                this.index = index;
                this.probability = probability;
            }
            @Override
            public int compareTo(node o){
                return Double.compare(o.probability, probability);
            }
        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            Map<Integer, List<node>> map = new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(i, new ArrayList<node>());
            }
            for(int i=0;i<edges.length;i++){
                map.get(edges[i][0]).add(new node(edges[i][1], succProb[i]));
                map.get(edges[i][1]).add(new node(edges[i][0], succProb[i]));
            }
            double[] probs = new double[n];
            Arrays.fill(probs, 0);
            Queue<node> pq = new PriorityQueue<>();
            pq.offer(new node(start_node, 1));

            while(!pq.isEmpty()){
                node cur = pq.poll();
                int cur_index = cur.index;
                double prob = cur.probability;

                if(probs[cur_index] > prob) continue;

                List<node> nodes = map.get(cur_index);
                for(node toNode : nodes){
                    if(probs[toNode.index] < prob * toNode.probability ){
                        probs[toNode.index] = prob * toNode.probability;
                        pq.offer(new node(toNode.index, prob * toNode.probability));
                    }
                }
            }
            return probs[end_node];
        }
    }
}
