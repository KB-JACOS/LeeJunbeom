import java.io.*;
import java.util.*;

public class BOJ_4195 {
	static Map<String, String> parent;
	static Map<String, Integer> count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			parent = new HashMap<>();
			count = new HashMap<>();
			int n = Integer.parseInt(br.readLine());

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				// 처음 나온 친구는 자기 자신이 부모
				parent.putIfAbsent(a, a);
				parent.putIfAbsent(b, b);
				count.putIfAbsent(a, 1);
				count.putIfAbsent(b, 1);

				int size = union(a, b); // 친구 관계 합치기
				sb.append(size).append("\n");
			}
		}

		System.out.print(sb);
	}

	static String find(String x) {
		if (!parent.get(x).equals(x)) {
			parent.put(x, find(parent.get(x)));
		}
		return parent.get(x);
	}

	static int union(String a, String b) {
		String rootA = find(a);
		String rootB = find(b);

		if (!rootA.equals(rootB)) {
			// rootB를 rootA 밑으로 연결
			parent.put(rootB, rootA);
			count.put(rootA, count.get(rootA) + count.get(rootB));
		}

		return count.get(find(a));
	}
}
