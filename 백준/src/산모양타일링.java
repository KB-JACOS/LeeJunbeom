public class 산모양타일링 {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(4, new int[] {1,1,0,1});
	}

	static class Solution {
		public int solution(int n, int[] tops) {
			int[][] dp = new int[n+1][2];

			// 첫 번째 칸에 겹칠 수 있는 빨간 마름모 개수
			// 두 번째 칸에는 겹칠 수 없는 마름모 개수

			dp[1][1] = 1;
			dp[1][0] = (tops[0] == 1) ? 3 : 2;

			for(int i=2;i<=n;i++){
				if(tops[i-1] == 1){
					dp[i][0] = (dp[i-1][0] * 3 + dp[i-1][1] * 2) % 10007;
					dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % 10007;
				}else {
					dp[i][0] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % 10007;
					dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
				}
			}

			int cnt = (dp[n][1] + dp[n][0]) % 10007;

			return cnt;
		}
	}
}
