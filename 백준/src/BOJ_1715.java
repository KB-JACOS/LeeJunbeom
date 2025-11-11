import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1715 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> que = new PriorityQueue<>();

		for(int i=0;i<n;i++){
			int x = Integer.parseInt(br.readLine());
			que.add(x);
		}

		int sum = 0;

		while(que.size() > 1){
			Integer a = que.poll();
			Integer b = que.poll();
			if(a == null) a = 0;
			if(b == null) b = 0;

			sum += a + b;

			que.add(a+b);
		}

		System.out.println(sum);
	}
}
