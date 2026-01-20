import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_20437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			Map<Character, List<Integer>> map = new HashMap<>();

			for (int i = 0; i < W.length(); i++) {
				char c = W.charAt(i);
				map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
			}

			int min = Integer.MAX_VALUE;
			int max = -1;

			for (List<Integer> pos : map.values()) {
				if (pos.size() < K) continue;

				for (int i = 0; i <= pos.size() - K; i++) {
					int length = pos.get(i + K - 1) - pos.get(i) + 1;
					min = Math.min(min, length);
					max = Math.max(max, length);
				}
			}

			if (max == -1) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}
	}
}
