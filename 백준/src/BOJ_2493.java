import java.io.*;
import java.util.*;

public class BOJ_2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[n];
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = 0;
			} else {
				result[i] = stack.peek()[1];
			}

			stack.push(new int[]{arr[i], i + 1});
		}

		StringBuilder sb = new StringBuilder();
		for (int x : result) sb.append(x).append(" ");
		System.out.println(sb);
	}
}
