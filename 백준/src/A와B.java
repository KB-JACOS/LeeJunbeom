import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A와B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		StringBuilder sb;

		while (s.length() < t.length()) {
			if (t.charAt(t.length() - 1) == 'A'){
				t = t.substring(0, t.length() - 1);
			}
			else if (t.charAt(t.length() - 1) == 'B') {
				t = t.substring(0, t.length() - 1);
				sb = new StringBuilder();
				for(int i=t.length()-1;i>=0;i--){
					sb.append(t.charAt(i));
				}
				t = sb.toString();
			}
		}
		if(t.equals(s))
			System.out.println("1");
		else
			System.out.println("0");
	}
}
