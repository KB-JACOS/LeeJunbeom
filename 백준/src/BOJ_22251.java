import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ_22251 {

	static int[] x2 = {
		0b1111110, // 0
		0b0110000, // 1
		0b1101101, // 2
		0b1111001, // 3
		0b0110011, // 4
		0b1011011, // 5
		0b1011111, // 6
		0b1110000, // 7
		0b1111111, // 8
		0b1111011  // 9
	};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int maxStories = Integer.parseInt(st.nextToken());

		int digits = Integer.parseInt(st.nextToken());

		int maxChangeCnt = Integer.parseInt(st.nextToken());

		int nowNum = Integer.parseInt(st.nextToken());
		int nn = nowNum;
		int result = 0;

		char[] nowNumArr = new char[digits];

		for(int j = digits-1; j >= 0; j--){
			int a = nn % 10;
			nn  = nn / 10;

			if(a == 0){
				nowNumArr[j] = '0';
			}else{
				nowNumArr[j] = String.valueOf(a).charAt(0);
			}
		}

		for(int i=1;i<=maxStories;i++){
			if(i == nowNum) continue;

			char[] x = new char[digits];
			int now = i;
			for(int j = digits-1; j >= 0; j--){
				int a = now % 10;
				now  = now / 10;

				if(a == 0){
					x[j] = '0';
				}else{
					x[j] = String.valueOf(a).charAt(0);
				}
			}
			int cnt = 0;
			for(int j=0;j<digits;j++){
				cnt += Integer.bitCount(x2[Integer.parseInt(String.valueOf(nowNumArr[j]))]
					^ x2[Integer.parseInt(String.valueOf(x[j]))]);
			}

			if(cnt <= maxChangeCnt) {
				result++;
			};
		}

		System.out.println(result);

	}
}
