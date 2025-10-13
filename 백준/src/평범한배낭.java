import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 평범한배낭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int max = 0;

		int[][] dp = new int[n+1][w+1];
		List<int[]> list = new ArrayList<>();

		list.add(new int[] {0,0});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int nw = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new int[]{nw, v});
		}

		for(int i=1;i<list.size();i++){
			for(int j=1;j<=w;j++){
				if(list.get(i)[0] > j){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.max(dp[i - 1][j - list.get(i)[0]] + list.get(i)[1], dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[n][w]);
	}
}
