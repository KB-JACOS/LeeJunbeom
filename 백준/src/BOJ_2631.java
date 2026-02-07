import java.lang.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class BOJ_2631 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int x[] = new int[N];

		for(int i=0;i<N;i++){
			x[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N];
		dp[0] = 1;
		int mmax = 0;
		for(int i=1;i<N;i++){
			int max = 0;
			for(int j=0;j<i;j++){
				if(x[i] > x[j]){
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max +1;
			mmax = Math.max(mmax, dp[i]);
		}

		System.out.println(N - mmax);
	}
}
