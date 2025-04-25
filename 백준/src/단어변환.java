import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    public static void main(String[] args) throws IOException {
        Solution11 solution = new Solution11();
        System.out.println(solution.solution("hit", "dog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    static class Solution11 {
        static HashSet<String> visited = new HashSet<>();
        static int cnt = 0;

        public int solution(String begin, String target, String[] words) {
            Queue<String[]> queue = new LinkedList<>();
            queue.offer(new String[] {begin, "0"});
            bfs(queue, begin, target, words);
            return cnt;
        }

        public void bfs(Queue<String[]> queue, String begin, String target, String[] words) {

            while (!queue.isEmpty()) {
                String[] poll = queue.poll();

                if(poll[0].equals(target)) {
                    cnt = Integer.parseInt(poll[1])+1;
                    return;
                }

                for (String word : words) {

                    if (!visited.contains(word) && check(poll[0], word)) {
                        visited.add(word);
                        queue.add(new String[]{word, (Integer.parseInt(poll[1])+1) + ""});
                    }
                }
            }
        }

        public boolean check(String a, String b){
            char[] aa = a.toCharArray();
            char[] bb = b.toCharArray();
            int cnt = 0;

            for(int i=0;i<aa.length;i++){
                if(aa[i]==bb[i]){
                    cnt++;
                }
            }
            return cnt == a.length() - 1;
        }
    }
}
