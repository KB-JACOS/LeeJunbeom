import static java.lang.System.exit;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class 영어끝말잇기 {
    public static void main(String[] args) throws IOException {
        Solution4 solution = new Solution4();
        int[] solution1 = solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        for (int i : solution1) {
            System.out.println("result = " + i);
        }
    }
}

class Solution4 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int humanNumber = 0;
        int turn = 0;

        set.add(words[0]);

        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i]) || check(words[i-1], words[i]) || words[i].length() == 1){
                humanNumber = (i+1) % n == 0 ? n : (i+1) % n;
                turn = (i+1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                break;
            }
            else{
                set.add(words[i]);
            }
        }

        return new int[]{humanNumber, turn};
    }

    public boolean check(String a, String b){
        char[] a2 = a.toCharArray();
        char[] b2 = b.toCharArray();

        return a2[a2.length - 1] != b2[0];
    }
}