import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ_2098 {
	static int[][] dp;
	static int[][] edge;
	static int n;
	static boolean[] visited;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		edge = new int[n][n];

		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				edge[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[(int)Math.pow(2, n)][n];
		for(int j=0;j<(int)Math.pow(2, n); j++){
			Arrays.fill(dp[j], 100000000);
		}
		visited = new boolean[n];
		visited[0] = true;
		System.out.println(dfs(1, 0));

	}

	public static int dfs(int bit, int now){
		if(bit == (int)(Math.pow(2,n))-1){
			if (edge[now][0] == 0){
				return 100000000;
			}
			return edge[now][0];
		}

		if(dp[bit][now] != 100000000){
			return dp[bit][now];
		}

		for(int i=0;i<n;i++){
			if(!visited[i] && edge[now][i] != 0){
				visited[i] = true;
				dp[bit][now] = Math.min(edge[now][i] + dfs(bit + (int)Math.pow(2,i), i),
					dp[bit][now]);
				visited[i] = false;
			}
		}

		return dp[bit][now];
	}
}
