import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구준표의조약돌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int bMax = Integer.parseInt(st.nextToken());
        int WMin = Integer.parseInt(st.nextToken());

        char[] load = new char[N];
        load = br.readLine().toCharArray();

        List<Integer> bIndex = new ArrayList<>();

        bIndex.add(-1);
        for(int i=0;i<N;i++) {
            if(load[i] == 'B'){
                bIndex.add(i);
            }
        }
        bIndex.add(N);

        if(bMax >= bIndex.size()-2){
            if(N - (bIndex.size()-2) >= WMin) {
                System.out.println(N);
                return;
            }
            System.out.println("0");
            return;
        }
        int max = 0;
        int flag = 0;
        int startIdx = 0;
        for(int i=1;i<bIndex.size()-1;i++) {
            if(i > bMax){
                flag = 1;
            }
            if(flag == 1){
                startIdx++;
            }
            if(i >= bMax && bIndex.get(i+1)-bIndex.get(startIdx)-bMax-1 >= WMin){
                max = Math.max(max,bIndex.get(i+1)-1-bIndex.get(startIdx));
            }
        }
        System.out.println(max);
    }
}
