import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1249 {
	static int[] tox = {0,0,1,-1};
	static int[] toy = {1,-1,0,0};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++){
			int x = Integer.parseInt(br.readLine());

			int[][] map = new int[x][x];

			for(int j=0;j<x;j++){
				char[] a = br.readLine().toCharArray();
				for(int k=0;k<x;k++){
					map[j][k] = Integer.parseInt(String.valueOf(a[k]));
				}
			}

			Queue<int[]> que = new PriorityQueue<>((a,b) ->
			{
				return a[2] - b[2];
			});


			que.add(new int[] {0,0,0});

			int[][] nowCost = new int[x][x];

			for(int l = 0;l<x;l++){
				Arrays.fill(nowCost[l], 2147483647);
			}

			while(!que.isEmpty()){
				int[] poll = que.poll();

				int nowy = poll[0];
				int nowx = poll[1];
				int cost = poll[2];

				if(nowCost[nowy][nowx] < cost) continue;

				nowCost[nowy][nowx] = cost;

				for(int l=0;l<4;l++){
					int ny = nowy + toy[l];
					int nx = nowx + tox[l];

					if(ny >= 0 && ny < x && nx >= 0 && nx < x &&
					cost + map[ny][nx] < nowCost[ny][nx]){
						que.add(new int[]{ny,nx,cost + map[ny][nx]});
						nowCost[ny][nx] = cost + map[ny][nx];
					}
				}
			}

			System.out.println("#" + (i+1) + " " + nowCost[x-1][x-1]);
		}
	}
}
