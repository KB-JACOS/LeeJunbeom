import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ_17471 {
	static int min = Integer.MAX_VALUE;
	static int[] person;
	static int personTotal = 0;
	static Map<Integer, List<Integer>> map = new HashMap<>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		person =new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++){
			person[i] = Integer.parseInt(st.nextToken());
			personTotal += person[i];
		}

		for(int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			map.put(i, new ArrayList<>());
			List<Integer> li = map.get(i);
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++){
				li.add(Integer.parseInt(st.nextToken()));
			}
		}
		dfs(1, new ArrayList<>(), n);
		if(min == Integer.MAX_VALUE){
			System.out.println("-1");
			return;
		}
		System.out.println(min);

	}

	public static void dfs(int now, List<Integer> nowCombi, int n){
		List<Integer> controversyCombi = new ArrayList<>();

		for(int i=1;i<=n;i++){
			boolean check = true;
			for(int k : nowCombi){
				if(i == k) check = false;
			}
			if(check) controversyCombi.add(i);
		}

		if(check(nowCombi, controversyCombi, n)){

			int total = 0;
			for (Integer i : nowCombi) {
				total += person[i];
			}
			min = Math.min(Math.abs((personTotal - total) - total), min);
		}

		for(int i=now;i<=n;i++){
			nowCombi.add(i);
			dfs(i+1, nowCombi, n);
			nowCombi.remove(nowCombi.size()-1);
		}


	}

	public static boolean check(List<Integer> a, List<Integer> b, int n){

		boolean[] visited = new boolean[n+1];

		Queue<Integer> que = new LinkedList<>();
		if(a.isEmpty() || b.isEmpty()){
			return false;
		}
		que.add(a.get(0));
		visited[a.get(0)] = true;

		while(!que.isEmpty()){
			Integer poll = que.poll();

			List<Integer> list = map.get(poll);

			for(int k : list){
				if(!visited[k] && a.contains(k)){
					visited[k] = true;
					que.add(k);
				}
			}
		}

		for (Integer i : a) {
			if(!visited[i]){
				return false;
			}
		}

		visited = new boolean[n+1];

		que = new LinkedList<>();

		que.add(b.get(0));
		visited[b.get(0)] = true;

		while(!que.isEmpty()){
			Integer poll = que.poll();

			List<Integer> list = map.get(poll);

			for(int k : list){
				if(!visited[k] && b.contains(k)){
					visited[k] = true;
					que.add(k);
				}
			}
		}

		for (Integer i : b) {
			if(!visited[i]){
				return false;
			}
		}

		return true;

	}
}
