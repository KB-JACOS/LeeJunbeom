import java.util.*;

class 조합 {

    public static List<List<Integer>> x;

    public List<List<Integer>> combine(int n, int k) {
        x = new ArrayList<>();
        List<Integer> n3 = new ArrayList<>();
        combination(n,k,n3,1);

        return x;
    }

    public void combination(int n, int k, List<Integer> x2, int start){
        System.out.println(x2.toString());
        if(x2.size() == k){
            x.add(new ArrayList<>(x2));
            return;
        }

        for(int i=start;i<=n;i++){
                x2.add(i);
                combination(n, k, x2, i+1);
                x2.remove(x2.size()-1);
        }

    }
}