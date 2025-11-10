import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
	static int[] toX = {0,0,1,-1};
	static int[] toY = {1,-1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		while(n != 0){
			cnt++;
			int[][] miro = new int[n][n];
			Integer[][] value = new Integer[n][n];
			for(int i=0;i<n;i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++){
					miro[i][j] = Integer.parseInt(st.nextToken());
					value[i][j] = Integer.MAX_VALUE;
				}
			}

			PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[0] - b[0]);
			que.add(new int[] {0,0,miro[0][0]});
			value[0][0] = miro[0][0];

			while(!que.isEmpty()){
				int[] poll = que.poll();

				int Y = poll[0];
				int X = poll[1];
				int sum = poll[2];
				if(sum > value[Y][X]) continue;

				for(int i=0;i<4;i++){
					int nextY = Y + toY[i];
					int nextX = X + toX[i];

					if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n &&
					sum + miro[nextY][nextX] < value[nextY][nextX]){
						value[nextY][nextX] = sum + miro[nextY][nextX];
						que.add(new int[] {nextY, nextX, value[nextY][nextX]});
					}
				}
			}
			System.out.println("Problem " +  cnt + ": " + value[n-1][n-1]);
			n = Integer.parseInt(br.readLine());
		}
	}
}
