import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2513 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int apt = Integer.parseInt(st.nextToken());

		int limit = Integer.parseInt(st.nextToken());

		int school = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> leftQue = new PriorityQueue<>(
			(a1, a2) -> {
				if (a1[0] == a2[0]) return a2[1] - a1[1];
				return a2[0] - a1[0];
			}
		);

		PriorityQueue<int[]> rightQue = new PriorityQueue<>(
			(a1, a2) -> {
				if (a1[0] == a2[0]) return a2[1] - a1[1];
				return a2[0] - a1[0];
			}
		);

		for (int i=0;i<apt;i++){
			st = new StringTokenizer(br.readLine());
			int location = Integer.parseInt(st.nextToken()) - school;
			int cnt = Integer.parseInt(st.nextToken());

			if(location < 0) {
				leftQue.add(new int[] {Math.abs(location), cnt});
			}else{
				rightQue.add(new int[] {Math.abs(location), cnt});
			}
		}
		int last = 0;
		while(!leftQue.isEmpty()){

			int can = limit;
			int max = 0;
			while(can >= 0) {
				int[] poll = leftQue.poll();
				if (poll == null) break;
				// System.out.println("poll[0] "+poll[0]);
				can -= poll[1];
				if(can  < 0){
					leftQue.add(new int[] {poll[0], Math.abs(can)});
				}
				max = Math.max(max, poll[0]);
			}
			last += max * 2;
			// System.out.println("left" + max);
		}

		while(!rightQue.isEmpty()){

			int can = limit;
			int max = 0;
			while(can >= 0) {
				int[] poll = rightQue.poll();
				if (poll == null) break;
				can -= poll[1];
				if(can  < 0){
					rightQue.add(new int[] {poll[0], Math.abs(can)});
				}
				max = Math.max(max, poll[0]);
			}
			last += max * 2;
			// System.out.println(max);
		}

		System.out.println(last);
	}
}
