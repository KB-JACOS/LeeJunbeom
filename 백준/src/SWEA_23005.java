import java.io.*;

public class SWEA_23005 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			char[] s = br.readLine().toCharArray();
			int l = 0, r = s.length - 1;
			int cnt = 0;
			boolean ok = true;

			while (l < r) {
				if (s[l] == s[r]) {
					l++;
					r--;
				} else if (s[l] == 'x') {
					l++;
					cnt++;
				} else if (s[r] == 'x') {
					r--;
					cnt++;
				} else {
					ok = false;
					break;
				}
			}

			System.out.println(ok ? cnt : -1);
		}
	}
}