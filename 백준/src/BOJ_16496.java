import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BOJ_16496 {

	static int N;
	static String[] x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		x = new String[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x[i] = st.nextToken();
		}

		Arrays.sort(x, (a, b) -> {
			String ab = a + b;
			String ba = b + a;

			BigDecimal num1 = new BigDecimal(ab);
			BigDecimal num2 = new BigDecimal(ba);

			// 큰 수가 먼저 오도록 (내림차순)
			if (num1.compareTo(num2) > 0) {
				return -1;
			} else if (num1.compareTo(num2) < 0) {
				return 1;
			} else {
				return 0;
			}
		});

		// 모든 숫자가 0인 경우 처리
		if (x[0].equals("0")) {
			bw.write("0\n");
			bw.flush();
			return;
		}

		for (String s : x) {
			bw.write(s);
		}
		bw.flush();
	}
}
