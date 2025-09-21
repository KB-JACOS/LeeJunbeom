import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(new int[][] {{0,0,0}, {0,0,0}, {0,0,0}});
	}

	static class Solution {

		static int[] toX = {0,0,1,-1};
		static int[] toY = {1,-1,0,0};
		static int min = Integer.MAX_VALUE;

		public int solution(int[][] board) {
			int dp[][][] = new int[board.length][board.length][2];

			Queue<int[]> que = new LinkedList<>();

			for(int i=0;i<board.length;i++){
				for(int j=0;j<board.length;j++){
					dp[i][j][0] = Integer.MAX_VALUE;
					dp[i][j][1] = Integer.MAX_VALUE;
				}
			}

			que.offer(new int[]{0,0,0,0});
			dp[0][0][0] = 0;

			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int cost = cur[0];
				int corner = cur[1];
				int nowY = cur[2];
				int nowX = cur[3];

				// 왼쪽, 오른쪽은 1로 저장  위, 아래는 -1로 저장
				if(nowY == board.length-1 && nowX == board[0].length-1) {
					min = Math.min(min, cost);
					continue;
				}

				for (int i=0;i<4;i++){
					int nextY = nowY+toY[i];
					int nextX = nowX+toX[i];
					if(nextY >= 0 && nextY < board.length && nextX >= 0 && nextX < board[0].length &&
					board[nextY][nextX] == 0) {
						// 다음 번에 상하로 갈 때
						if(i == 0 || i == 1){
							if(corner == 1){
								if(dp[nextY][nextX][1] >= cost + 600){
									dp[nextY][nextX][1] = cost + 600;
									que.offer(new int[]{cost+600,-1,nextY,nextX});
								}
							}
							else{
								if(dp[nextY][nextX][0] >= cost + 100){
									dp[nextY][nextX][0] = cost + 100;
									que.offer(new int[]{cost+100,-1,nextY,nextX});
								}
							}
						}

						// 다음번에 양옆으로 갈 때
						if(i == 2 || i == 3){
							if(corner == -1){
								if(dp[nextY][nextX][1] >= cost + 600){
									dp[nextY][nextX][1] = cost + 600;
									que.offer(new int[]{cost+600,1,nextY,nextX});
								}
							}
							else{
								if(dp[nextY][nextX][0] >= cost + 100){
									dp[nextY][nextX][0] = cost + 100;
									que.offer(new int[]{cost+100,1,nextY,nextX});
								}
							}
						}
					}
				}
			}

			System.out.println(min);
			return min;
		}
	}
}
