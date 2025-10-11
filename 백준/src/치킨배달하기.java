import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달하기 {
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static List<int[]> visited = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int m;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) house.add(new int[]{i,j});
				if(t == 2) chicken.add(new int[]{i,j});
			}
		}
		dfs(0);
		System.out.println(min);
	}

	public static void dfs(int now){

		if(visited.size()==m){
			int sum = 0;

			for(int i=0;i<house.size();i++){
				int mi = Integer.MAX_VALUE;
				for(int j=0;j<visited.size();j++){
					mi = Math.min(mi,Math.abs(house.get(i)[0] - visited.get(j)[0]) + Math.abs(house.get(i)[1] - visited.get(j)[1]));
				}
				sum += mi;
			}

			min = Math.min(min,sum);
			return;
		}

		for(int i=now;i<chicken.size();i++){
			visited.add(new int[]{chicken.get(i)[0],chicken.get(i)[1]});
			dfs(i+1);
			visited.remove(visited.size()-1);
		}
	}
}
