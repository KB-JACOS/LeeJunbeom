import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][n];
		boolean[][] nulpangi = new boolean[n][n];

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;

		for(int i=0;i<n;i++){
			int nowEdge = 0, beforeEdge = board[i][0], flag= 0, le = 0;
			for(int j=0;j<n;j++){
				nowEdge = board[i][j];
				le++;
				if(beforeEdge > nowEdge){
					// 경사가 2이상 차이나면
					if(beforeEdge - nowEdge > 1){
						flag = 1;
						break;
					}
					int length = 1;
					int nextEdge = nowEdge;
					while(nowEdge == nextEdge && j+length < n){
						nextEdge = board[i][j+length];
						length++;
					}
					if(j+length != n) {
						length--;
					}
					if(length < l){
						flag = 1;
						break;
					}
					// 만약 이미 널판지를 깐 곳이라면 탈출
					for(int k=0;k<l;k++){
						// 널판지 체크
						if(nulpangi[i][j+k]){
							flag = 1;
							break;
						}
						// 널판지 없으면 설치
						nulpangi[i][j+k] = true;
					}
					if(flag == 1)break;
					j += length-1;
					beforeEdge = nextEdge;
					le = 0;
				}
				// 올라가는 경우
				else if(beforeEdge < nowEdge){
					le--;
					// 경사가 2이상 차이나면
					if(nowEdge - beforeEdge > 1){
						flag = 1;
						break;
					}
					if(le == 0) le = 1;
					if(le < l){
						flag = 1;
						break;
					}
					// 만약 이미 널판지를 깐 곳이라면 탈출
					for(int k=0;k<l;k++){
						// 널판지 체크
						if(j - k - 1 < 0){
							flag = 1;
							break;
						}
						if(nulpangi[i][j-k-1]){
							flag = 1;
							break;
						}
						// 널판지 없으면 설치
						nulpangi[i][j-k-1] = true;
					}
					if(flag == 1)break;
					le = 0;
				}
				beforeEdge = nowEdge;
			}
			if(flag == 0){
				cnt++;
			}
		}
		nulpangi = new boolean[n][n];

		// 세로 탐색
		for(int i=0;i<n;i++){
			int nowEdge = 0, beforeEdge = board[0][i], flag= 0, le = 0;
			for(int j=0;j<n;j++){
				nowEdge = board[j][i];
				le++;
				if(beforeEdge > nowEdge){
					// 경사가 2이상 차이나면
					if(beforeEdge - nowEdge > 1){
						flag = 1;
						break;
					}
					int length = 1;
					int nextEdge = nowEdge;
					while(nowEdge == nextEdge && j+length < n){
						nextEdge = board[j+length][i];
						length++;
					}
					if(j+length != n) {
						length--;
					}
					if(length < l){
						flag = 1;
						break;
					}
					// 만약 이미 널판지를 깐 곳이라면 탈출
					for(int k=0;k<l;k++){
						// 널판지 체크
						if(nulpangi[j+k][i]){
							flag = 1;
							break;
						}
						// 널판지 없으면 설치
						nulpangi[j+k][i] = true;
					}
					if(flag == 1)break;
					j += length-1;
					beforeEdge = nextEdge;
					le = 0;
				}
				// 올라가는 경우
				else if(beforeEdge < nowEdge){
					le--;
					// 경사가 2이상 차이나면
					if(nowEdge - beforeEdge > 1){
						flag = 1;
						break;
					}
					if(le == 0) le = 1;
					if(le < l){
						flag = 1;
						break;
					}
					// 만약 이미 널판지를 깐 곳이라면 탈출
					for(int k=0;k<l;k++){
						// 널판지 체크
						if(j - k - 1 < 0){
							flag = 1;
							break;
						}
						if(nulpangi[j-k-1][i]){
							flag = 1;
							break;
						}
						// 널판지 없으면 설치
						nulpangi[j-k-1][i] = true;
					}
					if(flag == 1)break;
					le = 0;
				}
				beforeEdge = nowEdge;
			}
			if(flag == 0){
				cnt++;
			}
		}

		System.out.println(cnt);

	}
}
