import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소수찾기 {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("011");
    }

    static class Solution {
        public static boolean[] visited;
        public static Set<Integer> check = new HashSet<>();
        public static int cnt = 0;
        public int solution(String numbers) {
            List<Integer> list = new ArrayList<>();
            visited = new boolean[numbers.length()+1];
            List<Integer> l = new ArrayList<>();
            dfs(l,numbers);
            return cnt;
        }

        public void dfs(List<Integer> list, String numbers){
            int c = toInt(list);
            if(isOdd(c)){
                if(!check.contains(c)) {
                    check.add(c);
                    cnt++;
                }
            }

            for(int i=0;i<numbers.length();i++){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
                    dfs(list,numbers);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }

        public int toInt(List<Integer> list){
            int sum = 0;
            for(int i=0;i<list.size();i++){
                sum = list.get(i) + sum * 10;
            }
            return sum;
        }

        public boolean isOdd(int n) {
            if(n == 0 || n == 1){
                return false;
            }
            for(int i=2;i<=Math.sqrt(n);i++) {
                if(n%i==0) {
                    return false;
                }
            }
            return true;
        }
    }
}
