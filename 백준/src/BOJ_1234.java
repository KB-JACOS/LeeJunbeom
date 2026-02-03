import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1234 {
	static int N = 0;
	static long[][][][] dp;
	static long max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		dp = new long[N+1][r+1][g+1][b+1];

		dfs(r,g,b,0,1);

		System.out.println(max);
	}

	public static long dfs(int nowR, int nowG, int nowB, int layer, long nowCnt){

		if(layer == N){
			max += nowCnt;
			dp[layer][nowR][nowG][nowB] = nowCnt;
			return nowCnt;
		}
		if(dp[layer+1][nowR][nowG][nowB] != 0){
			max += dp[layer][nowR][nowG][nowB];
			return dp[layer][nowR][nowG][nowB];
		}

		layer++;

		long cnt = 0;

		if (nowR >= layer) {
			cnt += dfs(nowR - layer, nowG, nowB, layer, nowCnt);
		}

		if (nowG >= layer) {
			cnt += dfs(nowR, nowG - layer, nowB, layer, nowCnt);
		}

		if (nowB >= layer) {
			cnt += dfs(nowR, nowG, nowB - layer, layer, nowCnt);
		}

		if(layer % 2 == 0) {
			if (nowR >= layer / 2 && nowG >= layer / 2) {
				int cc = 1;
				for(int i =1;i<=layer;i++){
					cc *= i;
				}
				int ccc = 1;
				for(int i=1;i<=layer/2;i++){
					ccc *= i;
				}
				cnt += dfs(nowR - layer / 2, nowG - layer / 2, nowB, layer, nowCnt*cc/ccc/ccc);
			}
		}

		if(layer % 2 == 0){
			int cc = 1;
			for(int i =1;i<=layer;i++){
				cc *= i;
			}
			int ccc = 1;
			for(int i=1;i<=layer/2;i++){
				ccc *= i;
			}
			if(nowR >= layer/2 && nowB >= layer/2){
				cnt += dfs(nowR - layer/2, nowG, nowB- layer/2, layer, nowCnt*cc/ccc/ccc);
			}
		}


		if(layer % 2 == 0){
			int cc = 1;
			for(int i =1;i<=layer;i++){
				cc *= i;
			}
			int ccc = 1;
			for(int i=1;i<=layer/2;i++){
				ccc *= i;
			}
			if(nowG >= layer/2 && nowB >= layer/2){
				cnt += dfs(nowR, nowG- layer/2, nowB- layer/2, layer, nowCnt*cc/ccc/ccc);
			}
		}

		if(layer % 3 == 0){
			int cc = 1;
			for(int i =1;i<=layer;i++){
				cc *= i;
			}
			int ccc = 1;
			for(int i=1;i<=layer/3;i++){
				ccc *= i;
			}

			if(nowR >= layer/3 && nowG >= layer/3 && nowB >= layer/3){
				cnt += dfs(nowR - layer / 3, nowG- layer/3, nowB- layer/3, layer, nowCnt*cc/ccc/ccc/ccc);
			}
		}

		dp[layer-1][nowR][nowG][nowB] = cnt;
		return cnt;
	}
}
