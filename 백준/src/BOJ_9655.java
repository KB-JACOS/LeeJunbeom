import java.io.*;

public class Main {
    static int N,x[][], max = 0;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        if(((N - 1) % 4) ==  0 || ((N - 3) % 4 == 0)){
            bw.write("SK");
        }
        else{
            bw.write("CY");
        }

        bw.flush();
    }

}