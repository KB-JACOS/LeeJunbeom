import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    public static void main(String[] args) throws IOException {
        Solution10 solution = new Solution10();
        System.out.println(solution.coinChange(new int[] {1}, 2147483647 ));
    }

    static class Solution10 {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;

            boolean[] visited = new boolean[amount + 1];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            visited[0] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int sum = current[0];
                int depth = current[1];

                for (int coin : coins) {
                    int next = sum + coin;
                    if (next > amount) continue;

                    if (next == amount) return depth + 1;

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(new int[]{next, depth + 1});
                    }
                }
            }

            return -1;
        }
    }
}
