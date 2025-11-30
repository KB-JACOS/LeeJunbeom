import java.io.*;
import java.util.*;

public class BOJ_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String category = st.nextToken();

				map.put(category, map.getOrDefault(category, 0) + 1);
			}

			int result = 1;
			for (int count : map.values()) {
				result *= (count + 1);
			}

			result -= 1;

			System.out.println(result);
		}
	}
}
