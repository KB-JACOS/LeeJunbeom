import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		int[] coins = new int[n];
		
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;

		for(int i=1;i<=k;i++){
			if(i % coins[0] == 0){
				dp[i] = 1;
			}
		}

		for (int i1 : dp) {
			System.out.print(" " + i1);
		}
		System.out.println();

		for(int i=1;i<n;i++){
			for(int j=1;j<=k;j++){
				if(j-coins[i] >= 0) {
					dp[j] += dp[j - coins[i]];
				}
			}
			for (int i1 : dp) {
				System.out.print(" " + i1);
			}
			System.out.println();
		}
		System.out.println(dp[k]);
	}
}
