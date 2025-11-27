import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 매출하락최소화 {
	class Solution {

		static int[][] dp;
		static int[] salesArr;
		static Map<Integer, List<Integer>> graph;

		public int solution(int[] sales, int[][] links) {

			int n = sales.length;
			dp = new int[n+1][2];
			salesArr = new int[n+1];

			for (int i=1; i<=n; i++) {
				salesArr[i] = sales[i-1];
			}

			graph = new HashMap<>();
			for (int i=1;i<=n;i++) graph.put(i,new ArrayList<>());

			for (int[] l : links) {
				graph.get(l[0]).add(l[1]);
			}

			dfs(1);

			return Math.min(dp[1][0], dp[1][1]);
		}

		public static void dfs(int now) {

			List<Integer> children = graph.get(now);

			if (children.isEmpty()) {
				dp[now][0] = 0;
				dp[now][1] = salesArr[now];
				return;
			}

			int sum0 = 0;
			int extra = Integer.MAX_VALUE;

			for (int child : children) {
				dfs(child);

				int childMin = Math.min(dp[child][0], dp[child][1]);
				sum0 += childMin;

				extra = Math.min(extra, dp[child][1] - childMin);
			}

			dp[now][1] = salesArr[now] + sum0;
			dp[now][0] = sum0 + extra;
		}
	}
}
