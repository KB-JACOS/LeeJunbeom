import java.io.*;
import java.lang.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class 제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=(int)Math.sqrt(i);j++){
                dp[i] = Math.min(dp[i],1 + dp[i - j*j]);
            }
        }

        System.out.println(dp[n]);
    }
}