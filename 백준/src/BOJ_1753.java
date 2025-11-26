import java.util.*;
import java.io.*;

public class BOJ_1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		Map<Integer, List<node>> path = new HashMap<>();

		for(int i=1;i<=V;i++){
			path.put(i, new ArrayList<>());
		}

		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			path.get(a).add(new node(b, w));
		}

		int[] value = new int[V+1];
		Arrays.fill(value, Integer.MAX_VALUE);

		Queue<node> que = new PriorityQueue<>((a,b) -> {
			return a.value - b.value;
		});

		value[start] = 0;

		que.add(new node(start, 0));

		while(!que.isEmpty()){
			node nowNode = que.poll();

			if(value[nowNode.toNode] < nowNode.value) continue;

			List<node> nodes1 = path.get(nowNode.toNode);

			for (node node : nodes1) {
				if(value[node.toNode] <= nowNode.value + node.value)continue;
				value[node.toNode] = nowNode.value + node.value;
				que.add(new node(node.toNode, nowNode.value+ node.value));
			}
		}

		for(int i=1;i<=V;i++){
			if(value[i] == Integer.MAX_VALUE){
				System.out.println("INF");
			}else{
				System.out.println(value[i]);
			}
		}

	}

	public static class node{
		int toNode;
		int value;
		public node(int toNode, int value){
			this.toNode = toNode;
			this.value = value;
		}
	}
}
