import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int cnt = 0;
    static int depth = 0;
    static int targetY;
    static int targetX;
    static int flag = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());

        recur(0,(int)Math.pow(2,n)-1,0, (int)Math.pow(2,n)-1) ;

        System.out.println(cnt-1);

    }

    public static void recur(int startY, int endY, int startX, int endX) {
        if (flag == 1) return;
        if(targetX < startX || targetX > endX || targetY < startY || targetY > endY) {
            depth += (endX - startX + 1) * (endX - startX + 1);
            return;
        }

        if(endY - startY == 1) {
            flag = 1;
            if(startY == targetY && startX == targetX) {
                cnt = depth+1;
                return;
            }
            if(startY == targetY && startX+1 == targetX) {
                cnt = depth += 2;
                return;
            }
            if(startY+1 == targetY && startX == targetX) {
                cnt = depth+=3;
                return;
            }
            if(startY+1 == targetY && startX+1 == targetX) {
                cnt = depth += 4;
                return;
            }
        }

        recur(startY, (startY + endY)/2, startX, (startX+endX)/2);
        recur(startY, (startY+endY)/2, (startX+endX+1)/2, endX);
        recur((startY + endY+1)/2, endY, startX, (startX + endX)/2);
        recur((startY + endY+1)/2, endY, (startX+endX+1)/2, endX);
    }
}
