import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {

    static int len;
    static int endX;
    static int endY;
    static int max = 0;
    static int[] X = {1,2,-1,-2};
    static int[] Y = {-2,-1,2,1};
    static int flag = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            flag = 0;
            len = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            visited = new boolean[len][len];

            Queue<int[]> queue = new LinkedList<>();
            visited[startX][startY] = true;
            queue.add(new int[]{startX,startY});
            bfs(0,queue);
            System.out.println(max);
            max = 0;
        }
    }

    public static void bfs(int depth, Queue<int[]> queue) {

        if(flag == 1){
            return;
        }

        Queue<int[]> newQueue = new LinkedList<>();

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == endX && now[1] == endY){
                max = depth;
                flag = 1;
                return;
            }

            for(int i=0;i<4;i++){
                int nowX = now[0]+X[i];
                int nowY = now[1]+Y[i];

                if(nowX >= 0 && nowX < len && nowY >= 0 && nowY < len){
                    if(!visited[nowX][nowY]) {
                        newQueue.add(new int[]{nowX, nowY});
                        visited[nowX][nowY] = true;
                    }
                }
            }

            for(int i=0;i<4;i++){
                int nowX = now[0]+X[i];
                int nowY = now[1]+Y[i]*-1;
                if(nowX >= 0 && nowX < len && nowY >= 0 && nowY < len){
                    if(!visited[nowX][nowY]) {
                        newQueue.add(new int[]{nowX, nowY});
                        visited[nowX][nowY] = true;
                    }
                }
            }
        }

        queue.addAll(newQueue);
        newQueue.clear();
        newQueue = null;
        bfs(depth+1,queue);
    }
}
