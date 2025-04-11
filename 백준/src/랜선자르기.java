import java.io.*;
import java.lang.*;
import java.util.StringTokenizer;


public class 랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int ma = 0;

        int x[] = new int[k];

        for(int i=0;i<k;i++){
            int a = Integer.parseInt(br.readLine());
            ma = Math.max(ma,a);
            x[i]=a;
        }

        long left = 1;
        long right = ma;
        long max = 0;

        while(left <= right){
            long cnt = 0;
            long mid = (left + right) / 2;

            for (int i : x) {
                cnt += i / mid;
            }
            if(cnt >= n){
                left = mid + 1;
                max = Math.max(max,mid);
            }else{
                right = mid-1;
            }
        }

        System.out.println(max);
    }
}
