import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9881 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] hills = new int[N];
		for (int i = 0; i < N; i++) {
			hills[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(hills);

		int minCost = Integer.MAX_VALUE;

		for (int start = 0; start <= 83; start++) {  // 100 - 17 = 83
			int end = start + 17;
			int cost = 0;

			for (int h : hills) {
				if (h < start) cost += (start - h) * (start - h);
				else if (h > end) cost += (h - end) * (h - end);
			}

			minCost = Math.min(minCost, cost);
		}

		System.out.println(minCost);
	}
}
