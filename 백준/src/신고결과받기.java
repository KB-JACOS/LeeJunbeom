import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;


public class 신고결과받기 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2 );

    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();

        for (String s : id_list) {
            map.putIfAbsent(s, new HashSet<>());
            result.putIfAbsent(s, 0);
        }

        for (String s : report) {
            String reporter = s.split(" ")[0];
            String receptor = s.split(" ")[1];

            map.get(reporter).add(receptor);
        }

        for (HashSet<String> value : map.values()) {
            for (String s : value) {
                result.put(s, result.getOrDefault(s, 0) + 1);
            }
        }

        List<String> out = new ArrayList<>();

        for (Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
            if(stringIntegerEntry.getValue() >= k){
                out.add(stringIntegerEntry.getKey());
            }
        }

        int[] re = new int[id_list.length];
        int reFlag = 0;

        for (String s : id_list) {
            HashSet<String> strings = map.get(s);
            for (String string : strings) {
                for (String s1 : out) {
                    if(s1.equals(string)){
                        re[reFlag]++;
                    }
                }
            }
            reFlag++;
        }

        return re;
    }
}