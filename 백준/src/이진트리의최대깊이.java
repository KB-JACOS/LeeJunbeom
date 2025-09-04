public class 이진트리의최대깊이 {

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        TreeNode root = new TreeNode(1,null,null);
        root.right = new TreeNode(2,null,null);
        solution.maxDepth(root);
    }


    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    static int max = 0;
    static class Solution15 {
        public int maxDepth(TreeNode root) {
            seek(root, 1);
            System.out.println("max = " + max);
            return max;
        }
    }

    static public void seek(TreeNode now, int depth) {
        if(now.left == null && now.right == null) {
            max = Math.max(max, depth);
        }

        if(now.left != null) {
            seek(now.left, depth + 1);
        }
        if(now.right != null) {
            seek(now.right, depth + 1);
        }
    }

}
