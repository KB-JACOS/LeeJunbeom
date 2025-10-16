import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두원 {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		double x1 = Double.parseDouble(st.nextToken());
		double y1 = Double.parseDouble(st.nextToken());
		double r1 = Double.parseDouble(st.nextToken());
		double x2 = Double.parseDouble(st.nextToken());
		double y2 = Double.parseDouble(st.nextToken());
		double r2 = Double.parseDouble(st.nextToken());

		double 중심사이의길이 = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));

		if(r1 >= 중심사이의길이 + r2){
			System.out.printf("%.3f", Math.PI * r2 * r2);
		}
		else if(r2 >= 중심사이의길이 + r1){
			System.out.printf("%.3f", Math.PI * r1 * r1);
		}
		else if(중심사이의길이 >= r1 + r2){
			System.out.printf("0.000");
		}
		else {

			double 큰원세타 =
				Math.acos((Math.pow(중심사이의길이, 2) + Math.pow(r1, 2) - Math.pow(r2, 2)) / (2 * 중심사이의길이 * r1)) * 2;
			double 작은원세타 =
				Math.acos((Math.pow(중심사이의길이, 2) + Math.pow(r2, 2) - Math.pow(r1, 2)) / (2 * 중심사이의길이 * r2)) * 2;

			double 큰원호의크기 = Math.pow(r1, 2) * 큰원세타 / 2;
			double 작은원호의크기 = Math.pow(r2, 2) * 작은원세타 / 2;

			double 큰원삼각형크기 = Math.pow(r1, 2) * Math.sin(큰원세타) / 2;
			double 작은원삼각형크기 = Math.pow(r2, 2) * Math.sin(작은원세타) / 2;

			double 교차부분크기 = (큰원호의크기 + 작은원호의크기) - (큰원삼각형크기 + 작은원삼각형크기);

			System.out.printf("%.3f", 교차부분크기);
		}


	}
}
