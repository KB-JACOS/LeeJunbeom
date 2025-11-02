import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int x[][] = new int[n][2];

		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i][0] = Integer.parseInt(st.nextToken());
			x[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(x, (a, b) ->{
			if(a[0] == b[0]) return a[1] - b[1];
			return a[0] - b[0];
		});

		for (int[] ints : x) {
			System.out.println(ints[0] + " " + ints[1]);
		}
	}
}
