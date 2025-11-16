import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17485 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] cost = new int[n][m];

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[n][m][3];

		for(int i=0;i<m;i++){
			dp[0][i][0] = cost[0][i];
			dp[0][i][1] = cost[0][i];
			dp[0][i][2] = cost[0][i];
		}

		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){
				if(j != 0) {
					dp[i][j][0] = Math.min(dp[i - 1][j-1][2] + cost[i][j], dp[i - 1][j][1] + cost[i][j]);
				} else{
					dp[i][j][0] = dp[i-1][j][1] + cost[i][j];
				}
				if(j != 0 && j != m-1) {
					dp[i][j][1] = Math.min(dp[i - 1][j - 1][2] + cost[i][j], dp[i - 1][j + 1][0] + cost[i][j]);
				}
				else if(j == 0){
					dp[i][j][1] = dp[i - 1][j + 1][0] + cost[i][j];
				} else{
					dp[i][j][1] = dp[i - 1][j - 1][2] + cost[i][j];
				}
				if(j != m-1) {
					dp[i][j][2] = Math.min(dp[i - 1][j][1] + cost[i][j], dp[i - 1][j + 1][0] + cost[i][j]);
				}
				else{
					dp[i][j][2] = dp[i - 1][j][1] + cost[i][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			min = Math.min(min, Math.min(dp[n-1][i][0], Math.min(dp[n-1][i][1], dp[n-1][i][2])));
		}
		System.out.println(min);
	}
}
