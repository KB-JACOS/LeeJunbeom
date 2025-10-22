import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] triangle = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];

		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++){
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = triangle[0][0];
		int max = dp[0][0];

		for(int i=1;i<n;i++){
			for(int j=0;j<=i;j++){
				int left = j-1 >= 0 ? j-1 : 0;
				int right = j == i ? j-1 : j;

				dp[i][j] = Math.max(dp[i-1][left], dp[i-1][right]) + triangle[i][j];
				max = Math.max(max, dp[i][j]);
			}
		}

		System.out.println(max);
	}
}
