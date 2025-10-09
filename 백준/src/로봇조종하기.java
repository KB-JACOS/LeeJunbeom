import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로봇조종하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int og[][] = new int[n][m];
		int dp[][][] = new int[n][m][3];

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				og[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0][1] = og[0][0];
		dp[0][0][2] = og[0][0];
		dp[0][0][0] = og[0][0];



		for(int i=1;i<m;i++){
			dp[0][i][2] = dp[0][i][0] = dp[0][i][1] = dp[0][i-1][1] + og[0][i];
		}

		// 0 위에서 아래로,  1 왼쪽에서 오른쪽,  2 오른쪽에서 왼쪽
		for(int i=1;i<n;i++){

			// 위에서 아래
			for(int j=0;j<m;j++){
				dp[i][j][1] = dp[i][j][2] = dp[i][j][0] = Math.max(dp[i-1][j][0],Math.max(dp[i-1][j][1], dp[i-1][j][2])) + og[i][j];
			}

			// 왼쪽에서 오른쪽
			for(int j=1;j<m;j++){
				dp[i][j][1] = Math.max(dp[i][j-1][1] + og[i][j], dp[i][j][0]);
			}

			// 오른쪽에서 왼쪽
			for(int j=m-2;j>=0;j--){
				dp[i][j][2] = Math.max(dp[i][j+1][2] + og[i][j], dp[i][j][0]);
			}
		}

		// System.out.println(Arrays.deepToString(dp));

		System.out.println(Math.max(dp[n-1][m-1][0], dp[n-1][m-1][1]));
	}
}
