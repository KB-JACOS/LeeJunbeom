import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int chu[] = new int[n];
		for (int i = 0; i < n; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(chu);

		int max = 0;

		for(int i=0;i<n;i++){
			if(max >= chu[i]-1){
				max += chu[i];
			}else{
				System.out.println(max+1);
				System.exit(0);
			}
		}
		System.out.println(max+1);
	}
}
