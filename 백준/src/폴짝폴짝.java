import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 폴짝폴짝 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int mul = arr[cur[0]];
            if (cur[0] == end) {
                System.out.println(cur[1]);
                return;
            }
            int nowIdx = cur[0];
            while(nowIdx > 0) {
                if(!visited[nowIdx]) {
                    queue.offer(new int[]{nowIdx, cur[1] + 1});
                    visited[nowIdx] = true;
                }
                nowIdx -= mul;
            }

            nowIdx = cur[0];
            while(nowIdx <= n) {
                if(!visited[nowIdx]) {
                    queue.offer(new int[]{nowIdx, cur[1] + 1});
                    visited[nowIdx] = true;
                }
                nowIdx += mul;
            }
        }
        System.out.println("-1");
    }
}
