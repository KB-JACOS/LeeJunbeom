import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15591 {
	static Map<Integer, List<int[]>> map;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		map = new HashMap<>();
		for(int i=1;i<=n;i++){
			map.put(i,new ArrayList<>());
		}

		for(int i=0;i<n-1;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map.get(a).add(new int[] {b,cost});
			map.get(b).add(new int[] {a,cost});
		}

		for(int i=0;i<q;i++){
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			visited = new boolean[n+1];
			cnt = 0;
			visited[v] = true;
			dfs(v,Integer.MAX_VALUE, k);
			System.out.println(cnt);
		}

	}

	public static void dfs(int st, int min, int k){
		List<int[]> list = map.get(st);
		for (int[] value : list) {
			if(!visited[value[0]]){
				if (Math.min(min, value[1])>=k) cnt++;
				visited[value[0]] = true;
				dfs(value[0], Math.min(min, value[1]), k);
			}
		}
	}
}
