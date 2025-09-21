import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static int[] toX = {0,1,0,-1};
	static int[] toY = {-1,0,1,0};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());

		int[][] field = new int[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		field[startY][startX] = 2;
		while(true){
			int flag= 0;

			for (int i = 0; i < 4; i++) {
				direction = direction - 1 == -1 ? 3 : direction - 1;
				int nextY = startY + toY[direction];
				int nextX = startX + toX[direction];

				if(field[nextY][nextX] == 0){
					cnt++;
					startY = nextY;
					startX = nextX;
					field[nextY][nextX] = 9;
					flag = 1;
					break;
				}
			}
			if(flag == 1) continue;

			int backDirection = (direction + 2) % 4;
			int nextY = startY + toY[backDirection];
			int nextX = startX + toX[backDirection];
			if(field[nextY][nextX] != 1){
				startY = nextY;
				startX = nextX;
				continue;
			}
			break;
		}

		System.out.println(cnt);
	}
}
