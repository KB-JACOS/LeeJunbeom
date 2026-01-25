import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.lang.model.SourceVersion;

public class BOJ_2632 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int target = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());


		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] al = new int[a];
		int[] bl = new int[b];

		for(int i=0;i<a;i++){
			al[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<b;i++){
			bl[i] = Integer.parseInt(br.readLine());
		}

		int sumA[][] = new int[a][a];
		int sumB[][] = new int[b][b];

		for(int i=0;i<a;i++){
			int j = i+1;
			int sum = al[i];
			int flag = 0;
			sumA[i][flag++] = sum;
			while(j != i){
				if(j == a) j = 0;
				if(i==j) break;
				sum += al[j];
				sumA[i][flag++] = sum;

				j++;
			}
		}

		for(int i=0;i<b;i++){
			int j = i+1;
			int sum = bl[i];
			int flag = 0;
			sumB[i][flag++] = sum;
			while(j != i){
				if(j == b) j = 0;
				if(i==j) break;
				sum += bl[j];
				sumB[i][flag++] = sum;

				j++;
			}
		}

		int[] aResult = new int[target+1];
		int[] bResult = new int[target+1];

		for (int[] ints : sumA) {
			for (int anInt : ints) {
				if(anInt > target) break;
				aResult[anInt]++;
			}
		}

		for (int[] ints : sumB) {
			for (int anInt : ints) {
				if(anInt > target) break;
				bResult[anInt]++;
			}
		}

		int result = 0;

		aResult[0] = 1;
		bResult[0] = 1;


		int aAllSum = sumA[0][a-1];

		if(target >= aAllSum){
			aResult[aAllSum] = 1;
		}

		int bAllSum = sumB[0][b-1];

		if(target >= bAllSum){
			bResult[bAllSum] = 1;
		}

		for(int i=0, j = target;i<=target;i++,j--){
			result += aResult[i] * bResult[j];
		}

		System.out.println(result);

	}
}
