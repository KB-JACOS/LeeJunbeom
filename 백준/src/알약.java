import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 알약 {
	static long[][] dp = new long[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			sb.append(dfs(n, 0)).append("\n");
		}

		System.out.print(sb);
	}

	static long dfs(int w, int h) {
		if (w == 0 && h == 0) return 1;
		if (dp[w][h] != 0) return dp[w][h];

		long ways = 0;
		if (w > 0) ways += dfs(w - 1, h + 1);
		if (h > 0) ways += dfs(w, h - 1);

		return dp[w][h] = ways;
	}
}
