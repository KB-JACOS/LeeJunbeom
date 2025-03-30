import java.io.*;
import java.lang.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        // 초기화
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (char c : input) {
            leftStack.push(c);
        }

        // 명령 시작
        int directingCount = Integer.parseInt(br.readLine());

        for(int i=0;i<directingCount;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] direction = new char[st.countTokens()];
            int index = 0;
            while(st.hasMoreTokens()) {
                direction[index++] = st.nextToken().charAt(0);
            }

            if(direction[0] == 'L' && !leftStack.isEmpty()) {
                Character pop = leftStack.pop();
                rightStack.push(pop);
            }

            else if(direction[0] == 'D' && !rightStack.isEmpty()) {
                Character pop = rightStack.pop();
                leftStack.push(pop);
            }

            else if(direction[0] == 'B' && !leftStack.isEmpty()) {
                leftStack.pop();
            }

            else if(direction[0] == 'P') {
                leftStack.push(direction[1]);
            }

        }

        // 출력 시작
        StringBuilder sb = new StringBuilder();

        while(!leftStack.isEmpty()) {
            char pop = leftStack.pop();
            rightStack.push(pop);
        }

        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());

    }
}