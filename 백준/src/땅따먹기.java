import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 땅따먹기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		HashMap<Long, Long> map = new HashMap<>();

		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			long cnt = Long.parseLong(st.nextToken());
			map = new HashMap<>();
			int flag = 0;
			for(int j=0;j<cnt;j++){
				long byung = Long.parseLong(st.nextToken());
				long bCnt = map.getOrDefault(byung,0L)+1;
				if(bCnt > cnt/2){
					System.out.println(byung);
					flag++;
					break;
				}
				map.put(byung,bCnt);
			}
			if(flag == 0){
				System.out.println("SYJKGW");
			}
		}
	}
}
