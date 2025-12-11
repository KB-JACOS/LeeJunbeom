import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		long cnt = 0;

		Set<Long> set = new HashSet<>();

		for(int i=2;i<=Math.sqrt(max);i++){
			long check = (long)i *i;
			if(check > max) break;

			long start = 0;
			if(min % check == 0){
				start = min / check;
			}else {
				start = min / check + 1;
			}

			long end = max / check;

			for(long j = start; j <= end;j++){
				set.add(check * j);
			}
		}

		System.out.println((max - min + 1) - set.size());
	}
}
