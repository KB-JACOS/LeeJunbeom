import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 키순서 {
    static int totalCnt = 0;
    static int cnt = 0;
    static int[][] x;
    static int n;
    static int m;
    static boolean visited[];
    static List<List<Integer>> toList = new ArrayList<>();
    static List<List<Integer>> backList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = new int[m][2];
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++){
            toList.add(new ArrayList<>());
            backList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            x[i][0] = Integer.parseInt(st.nextToken());
            x[i][1] = Integer.parseInt(st.nextToken());
            toList.get(x[i][0]).add(x[i][1]);
            backList.get(x[i][1]).add(x[i][0]);
        }

        for(int i=1;i<=n;i++){
            visited[i] = true;
            cnt = 0;
            toDfs(i);
            backDfs(i);
            visited = new boolean[n+1];
        }
        System.out.println(totalCnt);
    }

    public static void toDfs(int now){
        for(int i=0;i<toList.get(now).size();i++){
            if(!visited[toList.get(now).get(i)]){
                visited[toList.get(now).get(i)] = true;
                cnt++;
                toDfs(toList.get(now).get(i));
            }
        }
    }

    public static void backDfs(int now){

        if(cnt == n-1){
            totalCnt++;
        }

        for(int i=0;i<backList.get(now).size();i++){
            if(!visited[backList.get(now).get(i)]){
                visited[backList.get(now).get(i)] = true;
                cnt++;
                backDfs(backList.get(now).get(i));
            }
        }
    }
}
