import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 종이접기 {
    static boolean check = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            check = true;
            char[] x = br.readLine().toCharArray();
            int paper[] = new int[x.length];

            for(int j=0;j<x.length;j++){
                paper[j]=Integer.parseInt(x[j]+"");
            }

            // 여기까지 입출력

            devide(paper,0,x.length-1);

            if(check){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }

    public static void devide(int[] x,int left,int right){

        if(right - left < 2){
            return;
        }

        int mid = (left + right) / 2;

        for(int i=left,j=right;i<mid;i++,j--){
            if(x[i]+x[j] != 1){
                check = false;
                return;
            }
        }

        devide(x,left,mid-1);
    }
}
