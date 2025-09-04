public class 타겟넘버 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[] {1,1,1,1,1}, 3);
    }

    static class Solution {
        static int cnt = 0;
        public int solution(int[] numbers, int target) {
            dfs(0,target,numbers,0);
            return cnt;
        }


        public void dfs(int num, int target, int[] numbers, int start){
            if(start == numbers.length && num == target){
                cnt++;
            }

            for(int i=start;i<numbers.length;i++){
                dfs(num + numbers[i], target, numbers, i+1);
                dfs(num - numbers[i], target, numbers, i+1);
                return;
            }
        }

    }
}
