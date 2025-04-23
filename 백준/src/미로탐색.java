import java.io.*;
import java.lang.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class 미로탐색 {
    static int[][] miro;
    static boolean visited[][];
    static int x[] = {-1,1,0,0};
    static int y[] = {0,0,-1,1};
    static int N, M, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                miro[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        bfs(1, queue);
        System.out.println(result);
    }

    public static void bfs (int depth, Queue<int[]> queue){
        if(result != 0){
            return;
        }
        Queue<int[]> nextQueue = new ArrayDeque<>();
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+x[i];
                int ny = cur[1]+y[i];
                if (ny == N-1 && nx == M-1){
                    result = depth+1;
                    return;
                }
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx] && miro[ny][nx] == 1){
                    visited[ny][nx] = true;
                    nextQueue.offer(new int[]{nx,ny});
                }
            }
        }
        bfs(depth+1,nextQueue);
    }
}
