import java.util.ArrayList;
import java.util.List;

public class 감염된폴더 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        solution17.solution(new String[][] {{"root", "apps"}, {"apps", "chrome"}, {"apps", "vscode"}}, "chrome", "vscode");
    }

    static class Solution17 {
        static List<String> pAcs;
        static List<String> qAcs;
        static boolean visited[];
        public String solution(String[][] folders, String p, String q) {
            pAcs = new ArrayList<>();
            qAcs = new ArrayList<>();

            seek(folders, p, q, folders[0][0], new ArrayList<>());
            int minLength = Math.min(pAcs.size(), qAcs.size());
            for (int i = minLength-1; i >= 0; i--) {
                if(pAcs.get(i).equals(qAcs.get(i))) {
                    return pAcs.get(i);
                }
            }
            return "root";
        }

        public static void seek(String[][] folders, String p, String q, String now, List<String> Acs) {
            if(now.equals(p)) {
                Acs.add(now);
                pAcs.addAll(Acs);
                Acs.remove(Acs.size()-1);
            }
            if(now.equals(q)) {
                Acs.add(now);
                qAcs.addAll(Acs);
                Acs.remove(Acs.size()-1);
            }

            for (String[] folder : folders) {
                if(folder[0].equals(now)) {
                    Acs.add(now);
                    seek(folders, p, q, folder[1], Acs);
                    Acs.remove(Acs.size() - 1);
                }
            }
        }
    }
}
