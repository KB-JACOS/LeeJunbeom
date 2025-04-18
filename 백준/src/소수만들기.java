import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class 소수만들기 {
    public static void main(String[] args) throws IOException {
        Solution5 solution = new Solution5();
        solution.solution(new int[] {1,2,3,4});
    }
}

class Solution5 {
    static int cnt =0 ;
    static int[] dp = new int[3000];
    public int solution(int[] nums) {

        dfs(0, nums, 0,0);
        return cnt;
    }

    public void dfs(int depth, int[] nums, int sum, int start){
        if(depth == 3){
            if(dp[sum] == 1){
                cnt++;
                return;
            }
            if(check(sum)){
                dp[sum] = 1;
                cnt++;
            }
            return;
        }
        for(int i=start;i< nums.length;i++){
            dfs(depth+1,nums,sum+nums[i], i+1);
        }
    }

    public boolean check(int sum){
        for(int i=2;i<=(int)Math.sqrt(sum);i++){
            if(sum % i == 0){
                return false;
            }
        }
        return true;
    }
}