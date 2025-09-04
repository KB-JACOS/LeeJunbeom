public class 전력망을둘로나누기 {

    public static void main(String[] args) {
        Solution17 solution =  new Solution17();
        solution.solution(6, new int[][] {{1,2}, {1,3}, {1,4}, {1,5}, {1,6} });
    }

    static class Solution17 {
        static int[] childCnt;
        static boolean[] visited;
        public int solution(int n, int[][] wires) {
            childCnt = new int[n+1];
            visited = new boolean[n+1];
            visited[wires[0][0]] = true;
            dfs(wires, wires[0][0]);
            int min = Integer.MAX_VALUE;
            double half = n/2.0;
            for(int i=1;i<=n;i++){
                if((Math.abs(half - min)) > Math.abs(half - childCnt[i])){
                    min = childCnt[i];
                }
            }

            for(int i=1;i<=n;i++){
                System.out.println(i + " = " +childCnt[i]);
            }

            System.out.println("min = " + min);
            System.out.println((n - min) - min);
            return Math.abs((n - min) - min);
        }

        public static int dfs(int[][] wires, int now){
            int sum = 0;
            for(int i=0;i<wires.length;i++){
                if(wires[i][0] == now && !visited[wires[i][1]]){
                    visited[wires[i][1]] = true;
                    sum += dfs(wires, wires[i][1]);
                }
                if(wires[i][1] == now && !visited[wires[i][0]]){
                    visited[wires[i][0]] = true;
                    sum += dfs(wires, wires[i][0]);
                    if(now == 3){
                        System.out.println("2끝나고 나서 = " + sum);
                    }
                }
            }
            childCnt[now] = sum+1;
//            if(now == 2){
//                System.out.println("sum2 = " + childCnt[now]);
//            }
//            if(now == 4){
//                System.out.println("sum4 = " + childCnt[now]);
//            }
//            if(now == 3){
//                System.out.println("sum3 = " + childCnt[now]);
//            }
            return childCnt[now];
        }
    }
}
