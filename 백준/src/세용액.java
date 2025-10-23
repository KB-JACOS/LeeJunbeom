import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 세용액 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long a=0,b=0,c=0;

		for(int i=0;i<N-2;i++){
			for(int j=i+1;j<N-1;j++){
				long sum = arr[i] + arr[j];
				long target = sum * -1;
				int index = Arrays.binarySearch(arr, j + 1, N, target);
				if (index >= 0) {
					System.out.println(arr[i] + " " + arr[j] + " " + arr[index]);
					return;
				}
				index = -index -1;
				if (index < N) {
					long total = sum + arr[index];
					if (Math.abs(total) < Math.abs(min)) {
						min = Math.abs(total);
						a = arr[i];
						b = arr[j];
						c = arr[index];
					}
				}
				if (index - 1 > j) {
					long total = sum + arr[index - 1];
					if (Math.abs(total) < Math.abs(min)) {
						min = Math.abs(total);
						a = arr[i];
						b = arr[j];
						c = arr[index - 1];
					}
				}if (index + 1 < N) {
					long total = sum + arr[index + 1];
					if (Math.abs(total) < Math.abs(min)) {
						min = Math.abs(total);
						a = arr[i];
						b = arr[j];
						c = arr[index + 1];
					}
				}
			}
		}

		System.out.println(a + " " + b + " " + c);
	}
}
