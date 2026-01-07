import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String x = br.readLine();
		int point = 0;
		int value = 1;
		while(true){
			String vx = String.valueOf(value);
			int k=0;
			for(int i=0;i<vx.length();i++){
				if(x.charAt(point) == vx.charAt(i)){
					k++;
					point++;
					if(point >= x.length()) break;
				}
			}

			if(point >= x.length()) break;
			value++;
		}

		System.out.println(value);
	}
}
