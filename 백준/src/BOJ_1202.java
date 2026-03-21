import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int bagCnt = Integer.parseInt(st.nextToken());

		int[][] eunji = new int[n][2];
		// 0은 무게, 1은 가격
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());

			eunji[i][0] = Integer.parseInt(st.nextToken());
			eunji[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] bag = new int[bagCnt];

		for(int i=0;i<bagCnt;i++){
			bag[i] = Integer.parseInt(br.readLine());
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a,b) -> {
				return b[1] - a[1];
			}
		);

		Arrays.sort(eunji, (a,b) -> {
			return a[0] - b[0];
		});

		Arrays.sort(bag);
		Long sum = 0L;
		int start = 0;
		for (int b : bag) {
			for (int i=start;i< eunji.length;i++) {
				if(eunji[i][0] <= b){
					pq.add(eunji[i]);
					start++;
				} else{
					break;
				}
			}
			if(!pq.isEmpty()){
				sum += pq.poll()[1];
			}
		}
		System.out.println(sum);
	}
}
