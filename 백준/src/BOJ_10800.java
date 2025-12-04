import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10800 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] balls = new int[n][4];
		int colorMax = 0;

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());

			int sequence = i;
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			balls[i][0] = sequence;
			balls[i][1] = color;
			balls[i][2] = size;

			colorMax = Math.max(colorMax, color);
		}

		Arrays.sort(balls, (a, b) -> a[2] - b[2]);

		int[][] colorSum = new int[colorMax+1][1];
		int sum = 0;

		int i = 0;
		while (i < n) {

			int j = i;
			while (j < n && balls[j][2] == balls[i][2]) j++;

			for (int k = i; k < j; k++) {
				balls[k][3] = sum - colorSum[balls[k][1]][0];
			}

			for (int k = i; k < j; k++) {
				sum += balls[k][2];
				colorSum[balls[k][1]][0] += balls[k][2];
			}

			i = j;
		}

		Arrays.sort(balls, (a, b) -> a[0] - b[0]);

		for (int[] ball : balls) {
			System.out.println(ball[3]);
		}
	}
}
