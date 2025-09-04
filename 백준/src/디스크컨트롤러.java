import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][] {{0,3}, {1,9}, {2,6}});
    }

    static class Solution {
        class Disk implements Comparable<Disk> {
            int workTime;
            int arriveTime;
            int jobNum;

            public Disk(int workTime, int arriveTime, int jobNum) {
                this.workTime = workTime;
                this.arriveTime = arriveTime;
                this.jobNum = jobNum;
            }

            @Override
            public int compareTo(Disk o) {
                if(workTime != o.workTime){
                    return workTime - o.workTime;
                }
                if(arriveTime != o.arriveTime){
                    return arriveTime - o.arriveTime;
                }
                return jobNum - o.jobNum;
            }
        }

        public int solution(int[][] jobs) {
            int n = jobs.length;
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

            PriorityQueue<Disk> pq = new PriorityQueue<>();
            int jobIdx = 0;
            int nowTime = 0;
            int total = 0;

            while (jobIdx < n || !pq.isEmpty()) {
                while (jobIdx < n && jobs[jobIdx][0] <= nowTime) {
                    pq.add(new Disk(jobs[jobIdx][1], jobs[jobIdx][0], jobIdx));
                    jobIdx++;
                }

                if (!pq.isEmpty()) {
                    Disk cur = pq.poll();
                    nowTime += cur.workTime;
                    total += nowTime - cur.arriveTime;
                } else {
                    nowTime++;
                }
            }

            return total / n;
        }
    }

}
