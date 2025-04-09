
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class 셔틀버스 {
    public static void main(String[] args) throws IOException {
        Solution3 solution = new Solution3();
        solution.solution(10,25,1,new String[] {"09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50",
                "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50"} );
    }
}

class Solution3 {
    public String solution(int n, int t, int m, String[] timetable) {

        List<Integer> minutes = toMinutes(timetable);
        Collections.sort(minutes);

        int[][] tansaram = new int[n][m];
        int bustime = 540;
        int result = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tansaram[i][j]=-1;
            }
        }

        for(int i=0;i<n;i++) {
            int tancnt = 0;
            int max = 0;

            for(int k=0;k<minutes.size();k++) {
                if (tancnt < m) {
                    if (minutes.get(k) <= bustime) {
                        tansaram[i][tancnt] = minutes.get(k);
                        max = Math.max(max, minutes.get(k));
                        tancnt++;
                        minutes.remove(k--);
                    }
                }
            }

            if(i + 1 == n){
                if(tansaram[i][m-1] != -1){
                    result = max -1;
                    break;
                }
                result = bustime;
            }
            bustime += t;
        }

        int hour = result / 60;
        int minute = result % 60;
        String reHour = "";
        String reMinute = "";

        if(hour < 10) reHour = "0"+hour;
        else{
            reHour = ""+hour;
        }
        if(minute < 10) {
            reMinute = "0" + minute;
            if(minute == 0)  reMinute = "00";
        }
        else{
            reMinute = ""+minute;
        }

        if(hour > 23){
            return "23:59";
        }

        return reHour+":"+reMinute;
    }

    public List<Integer> toMinutes(String[] timetable) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < timetable.length; i++) {
            String hour = timetable[i].split(":")[0];
            String minute = timetable[i].split(":")[1];
            list.add(Integer.parseInt(hour) * 60 + Integer.parseInt(minute));
        }

        return list;
    }
}