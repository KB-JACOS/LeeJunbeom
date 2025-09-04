import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parentCnt = new int[n+1];
		int[] hakki =  new int[n+1];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		Queue<int[]> queue = new LinkedList<>();

		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			list.get(parent).add(child);
			parentCnt[child]++;
		}

		for(int i=1;i<n;i++){
			if(parentCnt[i]==0){
				queue.add(new int[]{i,0});
			}
		}


		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			hakki[cur[0]] = cur[1];
			ArrayList<Integer> integers = list.get(cur[0]);

			for (Integer integer : integers) {
				parentCnt[integer]--;
				if(parentCnt[integer]==0){
					queue.add(new int[]{integer,cur[1]+1});
				}
			}
		}

		for(int i=1;i<=n;i++){
			System.out.print(" " + (hakki[i]+1));
		}

	}
}
