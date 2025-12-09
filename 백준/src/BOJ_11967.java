import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967 {
	public static void main(String[] args)throws IOException {
		int[] toX = {1,-1,0,0};
		int[] toY = {0,0,1,-1};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, List<String>> map = new HashMap<>();

		StringBuilder sb = new StringBuilder();

		for(int i=0;i<M;i++){
			st= new StringTokenizer(br.readLine());

			String a = (Integer.parseInt(st.nextToken()) - 1) + "," + (Integer.parseInt(st.nextToken()) - 1);
			String b = (Integer.parseInt(st.nextToken()) - 1) + "," + (Integer.parseInt(st.nextToken()) - 1);
			map.putIfAbsent(a, new ArrayList<>());

			map.get(a).add(b);
		}

		boolean[][] visited = new boolean[N][N];
		boolean[][] lights = new boolean[N][N];

		visited[0][0] = true;
		lights[0][0] = true;

		Queue<int[]> que = new LinkedList<>();

		que.add(new int[]{0,0});

		while(!que.isEmpty()){
			int[] poll = que.poll();

			int nowY = poll[0];
			int nowX = poll[1];

			// 불 킬 수 있는 곳 키고 만약 상하좌우 중 방문한 곳이 있다면 큐에 넣기
			String a = nowY + "," + nowX;

			List<String> canTurnsOn = map.get(a);
			if(canTurnsOn != null) {
				for (String s : canTurnsOn) {
					String[] split = s.split(",");
					int turnY = Integer.parseInt(split[0]);
					int turnX = Integer.parseInt(split[1]);
					if(visited[turnY][turnX] || lights[turnY][turnX]) continue;
					lights[turnY][turnX] = true;

					for (int i = 0; i < 4; i++) {
						int nY = turnY + toY[i];
						int nX = turnX + toX[i];

						if (nY >= 0 && nY < N && nX >= 0 && nX < N
							&& visited[nY][nX]) {
							que.add(new int[] {turnY, turnX});
							visited[turnY][turnX] = true;
							break;
						}
					}
				}
			}

			// 불 켜져있고 방문 안 한 곳 방문
			for(int i=0;i<4;i++){
				int nxY = nowY + toY[i];
				int nxX = nowX + toX[i];
				if(nxX >= 0 && nxX < N && nxY >= 0 && nxY < N
					&& lights[nxY][nxX] && !visited[nxY][nxX]){
					que.add(new int[] {nxY, nxX} );
					visited[nxY][nxX] = true;
				}
			}
		}
		int cnt = 0;

		for (boolean[] light : lights) {
			for (boolean b : light) {
				if(b) cnt++;
				// System.out.print(" " + b);
			}
			// System.out.println();
		}

		System.out.println(cnt);
	}
}
