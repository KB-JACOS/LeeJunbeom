import java.io.*;
import java.util.*;

public class BOJ_31965 {
	static long[] X, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		X = new long[n];
		S = new long[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++){
			X[i] = Long.parseLong(st.nextToken());
			S[i+1] = S[i] + X[i];
		}

		StringBuilder sb = new StringBuilder();

		for (int t=0;t<q;t++){
			st = new StringTokenizer(br.readLine());
			long L = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());

			int l = Arrays.binarySearch(X, L);
			if (l < 0) l = -l - 1;
			int r = Arrays.binarySearch(X, R);
			if (r < 0) r = -r - 2;

			if (l >= r) {
				sb.append(0).append("\n");
				continue;
			}

			int mid = (l + r) / 2;
			long costMid = cost(l, r, mid);
			long costLeft = cost(l, r, l);
			long costRight = cost(l, r, r);

			long result = Math.max(costLeft, costRight) - costMid;
			sb.append(result).append("\n");
		}

		System.out.print(sb);
	}

	static long cost(int l, int r, int i) {
		long left = X[i] * (i - l) - (S[i] - S[l]);
		long right = (S[r+1] - S[i+1]) - X[i] * (r - i);
		return left + right;
	}
}
