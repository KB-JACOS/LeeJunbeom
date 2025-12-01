import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2461 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] ban = new int[n][m];

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				ban[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] points = new int[n];
		int min = Integer.MAX_VALUE;
		int max = 0;

		for(int i=0;i<n;i++){
			Arrays.sort(ban[i]);
		}

		int minStudentIdx = 0, minClassIdx = 0;
		int chaiMin = Integer.MAX_VALUE;

		while(true){
			min = Integer.MAX_VALUE;
			max = 0;
			for(int i=0;i<n;i++){
				if(min > ban[i][points[i]]){
					min = ban[i][points[i]];
					minStudentIdx = points[i];
					minClassIdx = i;
				}
				max = Math.max(ban[i][points[i]], max);
			}
			int chai = max - min;

			if(chaiMin > chai){
				chaiMin = chai;
			}
			if (++minStudentIdx >= m) break;
			points[minClassIdx]++;
		}

		System.out.println(chaiMin);

	}
}
