import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class 바이러스_2606{
    static int N, con;
    static boolean check[], visited[];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        con = Integer.parseInt(br.readLine());

        check = new boolean[N+1];
        visited = new boolean[N+1];

        visited[1] = true;
        check[1] = true;

        int x[][] = new int[con][con];

        for(int  i = 0;i<con;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            x[i][0] = a;
            x[i][1] = b;

        }

        dfs(x,1);

        int cnt = 0;

        for(int  i = 0 ;i<N+1;i++){
            if(check[i]){
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt-1));
        bw.flush();
    }

    public static void dfs(int x[][], int now){
        for(int i = 0 ;i<con;i++){
            if(x[i][0] == now && !visited[x[i][1]]){
                visited[x[i][1]] = true;
                check[x[i][1]] = true;
                dfs(x,x[i][1]);
            }

            if(x[i][1] == now && !visited[x[i][0]]){
                visited[x[i][0]] = true;
                check[x[i][0]] = true;
                dfs(x,x[i][0]);
            }
        }
    }
}