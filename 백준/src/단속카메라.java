import java.util.Arrays;

public class 단속카메라 {

	static class Solution {
		public int solution(int[][] routes) {
			Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
			int cnt = 0;
			int min = Integer.MAX_VALUE;
			for (int[] route : routes) {
				if(min < route[0]){
					System.out.println("min = " + min);
					System.out.println("route[0] = " + route[0]);
					cnt++;
					min = route[1];
					continue;
				}
				min = Math.min(min, route[1]);
			}
			cnt++;
			System.out.println("cnt = " + cnt);
			return cnt;
		}
	}


	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(new int[][]{{-20,-15}, {-14, -5}, {-18, -13}, {-5,-3}});
	}
}
