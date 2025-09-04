import java.util.ArrayList;
import java.util.List;

public class 이진트리의최소공통조상 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Solution16 solution16 = new Solution16();
        solution16.lowestCommonAncestor(root, root.left.left, root.left.right.right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution16 {
        static List<TreeNode> pAcs = new ArrayList<>();
        static List<TreeNode> qAcs = new ArrayList<>();
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            pAcs = new ArrayList<>();
            qAcs = new ArrayList<>();
            ArrayList<TreeNode> trees = new ArrayList<>();
            seek(root,trees,p.val,q.val);

            int smallLength = Math.min(pAcs.size(), qAcs.size());
            for (int i = smallLength-1; i >= 0; i--) {
                if (pAcs.get(i).val == qAcs.get(i).val) {
                    return pAcs.get(i);
                }
            }
            return root;
        }

        public static void seek(TreeNode now, List<TreeNode> acs, int pValue, int qValue) {
            if(now.val == pValue){
                acs.add(now);
                pAcs.addAll(acs);
            }
            if(now.val == qValue){
                acs.add(now);
                qAcs.addAll(acs);
            }
            if(now.left != null) {
                acs.add(now);
                seek(now.left, acs, pValue, qValue);
                acs.remove(acs.size() - 1);
            }
            if(now.right != null) {
                acs.add(now);
                seek(now.right, acs, pValue, qValue);
                acs.remove(acs.size() - 1);            }
        }
    }
}
