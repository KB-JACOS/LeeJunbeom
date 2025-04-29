import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDegreeArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] sums = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                sums[i+1][j+1] = arr[i][j];
            }
        }

        for(int i = 1; i <= M; i++) {
            sums[1][i] += sums[1][i-1];
        }
        for(int i = 1; i <= N; i++) {
            sums[i][1] += sums[i-1][1];
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 2; j <= M; j++) {
                sums[i][j] += sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int l=0;l<k;l++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = sums[x][y] - sums[x][j-1] - sums[i-1][y] + sums[i-1][j-1];
            System.out.println(sum);
        }
    }
}
