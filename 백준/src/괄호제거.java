import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class 괄호제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        List<Integer[]> gualho = new ArrayList<>();
        Set<String> last = new TreeSet<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                stack.push(i);
            } else if (a[i] == ')') {
                gualho.add(new Integer[]{stack.pop(), i});
            }
        }

        int length = (int) Math.pow(2, gualho.size()) - 1;
        for (int i = 1; i <= length; i++) {
            List<Integer> index = new ArrayList<>();
            for (int j = 1; j <= (int) Math.pow(2, gualho.size() - 1); j <<= 1) {
                if ((i & j) != 0) {
                    index.add(log2(j));
                }
            }
            char[] copyArr = a.clone();
            for (Integer integer : index) {
                for (int k = 0; k < a.length; k++) {
                    if (k == gualho.get(integer)[0] || k == gualho.get(integer)[1]) {
                        copyArr[k] = 'a';
                    }
                }
            }
            String result = String.valueOf(copyArr).replace("a", "");
            last.add(result);
        }
        for (String s : last) {
            System.out.println( s);
        }
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}