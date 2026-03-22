import java.io.*;
import java.util.*;

public class BOJ_7569 {
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};

	static class Point {
		int z, y, x;
		Point(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int H = Integer.parseInt(st.nextToken()); // 높이

		int[][][] board = new int[H][N][M];
		Queue<Point> queue = new LinkedList<>();

		int unripeCount = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 1) {
						queue.add(new Point(i, j, k));
					} else if (board[i][j][k] == 0) {
						unripeCount++;
					}
				}
			}
		}

		if (unripeCount == 0) {
			System.out.println(0);
			return;
		}

		int days = 0;

		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nz = current.z + dz[i];
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (board[nz][ny][nx] == 0) {
						board[nz][ny][nx] = board[current.z][current.y][current.x] + 1;
						queue.add(new Point(nz, ny, nx));
						unripeCount--;
						days = Math.max(days, board[nz][ny][nx]);
					}
				}
			}
		}

		if (unripeCount > 0) {
			System.out.println(-1);
		} else {
			System.out.println(days - 1);
		}
	}
}