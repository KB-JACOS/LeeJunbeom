import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyAndRooms {
    public static void main(String[] args) {
        Solution8 solution = new Solution8();

        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0)
        );

        boolean result = solution.canVisitAllRooms(rooms);
        System.out.println(result); // 결과 확인용
    }

    static class Solution8 {
        static boolean[] visited;
        static List<List<Integer>> roomsCopy;

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            roomsCopy = rooms;
            visited = new boolean[rooms.size()];

            visited[0] = true;
            dfs(0);


            for (boolean b : visited) {
                if(!b){
                    return false;
                }
            }
            return true;
        }

        public void dfs(int now){
            for(int i=0;i<roomsCopy.get(now).size();i++){
                if(!visited[roomsCopy.get(now).get(i)]){
                    visited[roomsCopy.get(now).get(i)] = true;
                    dfs(roomsCopy.get(now).get(i));
                }
            }
        }
    }
}
