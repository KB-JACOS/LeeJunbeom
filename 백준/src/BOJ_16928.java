import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int ladderCnt = Integer.parseInt(st.nextToken());
		int snakeCnt = Integer.parseInt(st.nextToken());

		int[][] ladder = new int[ladderCnt][2];
		int[][] snake = new int[snakeCnt][2];

		for(int i=0;i<ladderCnt;i++){
			st = new StringTokenizer(br.readLine());
			ladder[i][0] = Integer.parseInt(st.nextToken());
			ladder[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<snakeCnt;i++){
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[200];

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {1,0});
		visited[1] = true;

		while(!que.isEmpty()){
			int[] now = que.poll();
			if(now[0] > 100) continue;
			if(now[0] == 100){
				System.out.println(now[1]);
				System.exit(0);
			}

			for(int i=1;i<7;i++){
				int next = now[0] + i;
				for(int j=0;j<ladderCnt;j++){
					if(next == ladder[j][0]){
						next = ladder[j][1];
						break;
					}
				}
				for(int j=0;j<snakeCnt;j++){
					if(next == snake[j][0]){
						next = snake[j][1];
						break;
					}
				}
				if(!visited[next]){
					visited[next] = true;
					que.add(new int[] {next, now[1] + 1});
				}
			}
		}
	}
}
