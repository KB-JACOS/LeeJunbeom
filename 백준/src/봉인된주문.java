import java.util.Arrays;

public class 봉인된주문 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(30, new String[] {"d", "e", "bb", "aa", "ae"});
	}

	static class Solution {
		public String solution(long n, String[] bans) {
			long[] banInt = new long[bans.length];
			for(int i=0;i<bans.length;i++){
				for(int j=0;j<bans[i].length();j++){
					char c = bans[i].charAt(j);
					int iC = c - 96;
					banInt[i] += ((long)Math.pow(26, bans[i].length() - j -1) * iC);
				}
			}

			Arrays.sort(banInt);
			for (long l : banInt) {
				if(n >= l) n++;
			}

			long mock = n;
			StringBuilder sb = new StringBuilder();
			while (mock > 0) {
				mock--;
				int r = (int)(mock % 26);
				sb.append((char)(r + 'a'));
				mock /= 26;
			}
			System.out.println(sb.reverse().toString());
			return sb.toString();
		}
	}
}
