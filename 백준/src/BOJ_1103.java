import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1103 {
	static int max = 0;
	static int[] ny = {0,0,1,-1};
	static int[] nx = {1,-1,0,0};
	static int[][] board;
	static int maxY, maxX;
	static boolean visited[][];
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		maxY = Integer.parseInt(st.nextToken());
		maxX = Integer.parseInt(st.nextToken());

		board = new int[maxY][maxX];
		visited = new boolean[maxY][maxX];
		dp = new int[maxY][maxX];

		for(int i=0;i<maxY;i++){
			String a = br.readLine();
			for(int j=0;j<maxX;j++){
				char c = a.charAt(j);
				if(c=='H') board[i][j] = 0;
				else{
					board[i][j] = Integer.parseInt(String.valueOf(c));
				}
			}
		}
		visited[0][0] = true;
		dfs(0,0, 1);
		System.out.println(max);

	}

	static public void dfs(int y, int x, int depth){
		if(max == -1) return;
		if(dp[y][x] != 0){
			max = Math.max(max, depth + dp[y][x]);
			return;
		}
		int move = board[y][x];
		if(move == 0){
			max = Math.max(max, depth-1);
			return;
		}
		max = Math.max(max, depth);
		for(int i=0;i<4;i++){
			int nextY = y + (ny[i] * move);
			int nextX = x + (nx[i] * move);
			if(nextY >= 0 && nextY < maxY && nextX >= 0 && nextX < maxX){
				if(visited[nextY][nextX]){
					max = -1;
					return;
				}
				visited[nextY][nextX] = true;
				dfs(nextY, nextX, depth+1);
				dp[y][x] = max - depth;
				visited[nextY][nextX] = false;
			}
		}
	}
}
