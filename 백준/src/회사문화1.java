import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 회사문화1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int chingChanCnt = Integer.parseInt(st.nextToken());

        int[] myUpper = new int[n];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            myUpper[i] = Integer.parseInt(st.nextToken());
        }
        myUpper[0] = 0;

        for(int i=0;i<chingChanCnt;i++){
            st = new StringTokenizer(br.readLine());
            int chingChanGet = Integer.parseInt(st.nextToken());
            int chingChanVal = Integer.parseInt(st.nextToken());
            dp[chingChanGet] += chingChanVal;
        }

        for(int i=1;i<=n;i++) {
            dp[i] += dp[myUpper[i - 1]];
        }

        for(int i=1;i<=n;i++){
            System.out.println(dp[i]+ " ");
        }
    }
}
