import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] x = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;

        for (int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(x[j] < x[i]) {
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
