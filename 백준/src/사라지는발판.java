public class 사라지는발판 {
	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.solution(new int[][] {{1,1,1}, {1,1,1}, {1,1,1}}, new int[] {1,0}, new int[] {1,2});
	}

	static class Solution {
		static int [] toX = {1,-1,0,0};
		static int [] toY = {0,0,-1,1};
		public int solution(int[][] board, int[] aloc, int[] bloc) {
			return dfs(board, aloc, bloc);
		}

		public int dfs(int[][] board, int[] aloc, int[] bloc){
			if(board[aloc[0]][aloc[1]] == 0) return 0;

			int nowY = aloc[0];
			int nowX = aloc[1];

			int cnt = 0;

			for(int i=0;i<4;i++){
				int nextY = nowY + toY[i];
				int nextX = nowX + toX[i];

				if(nextY >= 0 && nextY < board.length
					&& nextX >= 0 && nextX < board[0].length && board[nextY][nextX] == 1){

					board[nowY][nowX] = 0;
					int nCnt = dfs(board, bloc, new int[] {nextY, nextX}) + 1;

					if(cnt % 2 == 0){
						if(nCnt % 2 == 0){
							cnt = Math.max(cnt, nCnt);
						} else{
							cnt = nCnt;
						}
					} else{
						if(nCnt % 2 == 1) {
							cnt = Math.min(cnt, nCnt);
						}
					}
					board[nowY][nowX] = 1;
				}
			}
			return cnt;
		}
	}
}
