import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	public static int toX[] = {1,-1,0,0};
	public static int toY[] = {0,0,1,-1};
	public static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[m][n];
		Queue<int[]> que = new LinkedList<>();
		int[][] arr = new int[m][n];

		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1){
					que.add(new int[]{i,j,0});
					visited[i][j] = true;
				}
			}
		}

		if(que.isEmpty()){
			System.out.println("-1");
			return;
		}
		if(que.size() == m*n){
			System.out.println("0");
			return;
		}

		int max = 0;

		while(!que.isEmpty()){
			int[] cur = que.poll();
			int y = cur[0];
			int x = cur[1];
			int cnt = cur[2];
			max = Math.max(max,cnt);

			for(int i=0;i<4;i++){
				int nextX = x + toX[i];
				int nextY = y + toY[i];
				if(nextY >= 0 && nextY < m
				&& nextX >= 0 && nextX < n && arr[nextY][nextX] == 0){
					if(!visited[nextY][nextX]) {
						que.add(new int[] {nextY, nextX, cnt + 1});
						visited[nextY][nextX] = true;
					}
				}
			}
		}

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]!=-1){
					if(!visited[i][j]){
						System.out.println("-1");
						return;
					}
				}
			}
		}

		System.out.println(max);
	}
}
