import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int MAX = 10000;
		long[] dp = new long[MAX + 1];

		dp[0] = 1;

		for (int i = 1; i <= MAX; i++) {
			dp[i] += dp[i - 1];
		}

		for (int i = 2; i <= MAX; i++) {
			dp[i] += dp[i - 2];
		}

		for (int i = 3; i <= MAX; i++) {
			dp[i] += dp[i - 3];
		}

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}

		System.out.print(sb);
	}
}
