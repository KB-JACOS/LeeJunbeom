import java.util.*;
import java.io.*;
public class BOJ_2096 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] x = new int[n][3];
		StringTokenizer st;
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());

			x[i][0] = Integer.parseInt(st.nextToken());
			x[i][1] = Integer.parseInt(st.nextToken());
			x[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n][3];

		dp[0][0] = x[0][0];
		dp[0][1] = x[0][1];
		dp[0][2] = x[0][2];

		for(int i=1;i<n;i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + x[i][0];
			dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + x[i][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + x[i][2];
		}

		int max = Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);

		dp = new int[n][3];

		dp[0][0] = x[0][0];
		dp[0][1] = x[0][1];
		dp[0][2] = x[0][2];

		for(int i=1;i<n;i++){
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + x[i][0];
			dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + x[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + x[i][2];
		}

		int min = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
		System.out.println(max+ " " +  min);
	}
}
