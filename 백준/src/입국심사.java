import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class 입국심사 {
    // 같을 때는 왼쪽으로 탐색하기
    class Solution {
        public long solution(int n, int[] times) {
            long right = Long.MAX_VALUE;
            long left = 1;
            while(left <= right){
                long mid = left + (right - left) / 2;

                if(!check(times, n, mid)){
                    right = mid-1;
                    continue;
                }
                left = mid+1;
            }
            return left;
        }

        public boolean check(int[] times, int n, long now){
            long cnt = 0;

            for(int t : times){
                cnt += now / t;
                if(cnt >= n){
                    return false;
                }
            }
            return true;
        }
    }
}