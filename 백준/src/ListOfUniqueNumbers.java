import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int right = 0;
		int left = 0;
		long cnt = 1;

		boolean[] visited = new boolean[max+1];
		visited[arr[0]] = true;

		while(right < n) {
			right++;
			if(right >= n) break;
			if(!visited[arr[right]]) {
				visited[arr[right]] = true;
				cnt += right - left + 1;
			} else{
				while(left <= right) {
					if (arr[left] == arr[right]) {
						left++;
						break;
					}
					visited[arr[left]] = false;
					left++;
				}
				cnt += right - left + 1;
			}
		}

		System.out.println(cnt);
	}
}
