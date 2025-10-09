import java.io.*;
import java.util.*;


public class fourSquare {
    static int N=0,dp[];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp= new int[N+3];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        bw.write("" + cur(N));
        bw.flush();
    }

    static int cur(int n){
        if(dp[n] == 0 && n != 0){
            dp[n] = 50000;
            for(int i=(int)Math.sqrt(n);i>=2;i--){
                dp[n] = Math.min(cur(n - i*i), dp[n]);
            }
            dp[n]++;
        }

        return dp[n];

    }
}