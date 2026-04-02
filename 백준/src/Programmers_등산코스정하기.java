import java.util.*;
public class Programmers_등산코스정하기 {
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

		Map<Integer, List<int[]>> map = new HashMap<>();

		for(int i=1;i<=n;i++){
			map.put(i, new ArrayList<>());
		}

		for(int[] x: paths){
			map.get(x[0]).add(new int[] {x[1], x[2]});
			map.get(x[1]).add(new int[] {x[0], x[2]});
		}

		int[] dp = new int[n+1];

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
			return a[1] - b[1];
		});

		for(int i=0;i<n+1;i++){
			dp[i] = Integer.MAX_VALUE;
		}

		for(int x : gates){
			que.add(new int[] {x, 0});
		}
		int result = Integer.MAX_VALUE;
		int summitAnswer = 0;
		while(!que.isEmpty()){
			int[] poll = que.poll();

			int now = poll[0];
			int min = poll[1];

			if(dp[now] < min) continue;

			int flag = 0;
			for(int summit : summits){
				if(now == summit){
					if(result > min){
						result =  min;
						summitAnswer = summit;
					}
					if(result == min){
						if(summitAnswer > summit){
							summitAnswer = summit;
						}
					}
					flag = 1;
				}
			}
			if(flag == 1) continue;

			List<int[]> li = map.get(now);

			for(int[] l : li){

				if(dp[l[0]] > Math.max(min, l[1])){
					dp[l[0]] = Math.max(min, l[1]);
					que.add(new int[] {l[0], Math.max(min, l[1])});
				}
			}
		}
		int[] answer = new int[] {summitAnswer, result};
		return answer;
	}
}