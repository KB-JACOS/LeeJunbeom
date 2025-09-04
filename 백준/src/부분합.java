import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;

		int sum = arr[0];
		int cnt = 1;
		int min = Integer.MAX_VALUE;
		if(sum >= s){
			min = cnt;
		}
		while(start < n-1 || end < n-1) {
			if(sum < s && end < n-1){
				end++;
				sum += arr[end];
				cnt++;
			}
			else if(end == n-1 || sum >= s) {
				sum -= arr[start];
				start++;
				cnt--;
			}
			if(sum >= s && cnt < min){
				min = cnt;
			}
		}

		if(min == Integer.MAX_VALUE){
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(min);
	}
}
