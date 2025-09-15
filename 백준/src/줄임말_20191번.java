import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 줄임말_20191번 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		if (s == null || t == null) {
			System.out.println(-1);
			return;
		}
		if (s.length() == 0) {
			System.out.println(0);
			return;
		}

		List<Integer>[] pos = new ArrayList[26];
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int idx = c - 'a';
			if (pos[idx] == null) pos[idx] = new ArrayList<>();
			pos[idx].add(i);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (pos[c - 'a'] == null) {
				System.out.println(-1);
				return;
			}
		}

		int cnt = 1;
		int nowIndex = -1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			List<Integer> list = pos[c - 'a'];

			int left = 0, right = list.size() - 1;
			int found = -1;
			while (left <= right) {
				int mid = (left + right) >>> 1;
				if (list.get(mid) > nowIndex) {
					found = list.get(mid);
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			if (found == -1) {
				cnt++;
				nowIndex = list.get(0);
			} else {
				nowIndex = found;
			}
		}

		System.out.println(cnt);
	}
}
