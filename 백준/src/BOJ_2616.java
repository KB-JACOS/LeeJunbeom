import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class BOJ_2616 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] train = new int[n];

		for(int i=0;i<n;i++){
			train[i] = Integer.parseInt(st.nextToken());
		}

		int mCnt = Integer.parseInt(br.readLine());

		int[] rightDp = new int[n];
		int[] leftDp = new int[n];

		int leftMax = 0;
		int rightMax = 0;

		for(int i=0, j = n-1;i<mCnt-1;i++, j--){
			leftDp[i] = 0;
			rightDp[j] = 0;

			leftMax += train[i];
			rightMax += train[j];
		}

		int max = 0;

		for(int i=mCnt-1, j=-1; i<n; i++,j++){
			if(j >= 0){
				leftMax -= train[j];
			}
			leftMax += train[i];

			max = Math.max(max, leftMax);
			leftDp[i] = max;
		}

		max = 0;
		for(int i = n - mCnt, j = n;i>=0;i--, j--){
			if(j < n){
				rightMax -= train[j];
			}
			rightMax += train[i];

			max = Math.max(max, rightMax);
			rightDp[i] = max;
		}

		max = 0;
		int secondTrain = 0;
		for(int i=1;i<mCnt;i++){
			secondTrain += train[i];
		}
		int thirdTrain = 0;

		for(int i=mCnt,j=0;i<n;i++,j++){
			int firstTrain = leftDp[i-mCnt];
			if(i > mCnt){
				secondTrain -= train[j];
			}
			secondTrain += train[i];

			if(i < n-1) {
				thirdTrain = rightDp[i + 1];
			}else  thirdTrain = 0;

			max = Math.max(firstTrain+secondTrain+thirdTrain, max);
		}

		System.out.println(max);
	}
}
