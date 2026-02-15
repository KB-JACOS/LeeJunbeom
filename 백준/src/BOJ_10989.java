import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10989 {

	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int x[] = new int[N];

		for(int i = 0 ;i<N;i++){
			x[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(x);

		for (int i : x) {
			bw.write(i + "\n");
		}

		bw.flush();
	}


}