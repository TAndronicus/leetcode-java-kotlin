public class WC270E3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        String routeToStart = findTargetRecursively(root, startValue, ""),
                routeToDest = findTargetRecursively(root, destValue, "");
        return "U".repeat(routeToStart.length()) + routeToDest;
    }

    public static String findTargetRecursively(TreeNode treeNode, int target, String acc) {
        if (treeNode.val == target) return acc;
        if (treeNode.left != null) {
            String left = findTargetRecursively(treeNode.left, target, acc + "L");
            if (left != null) return left;
        }
        if (treeNode.right != null) {
            return findTargetRecursively(treeNode.right, target, acc + "R");
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        left.left = new TreeNode(3);
        root.left = left;
        root.right = new TreeNode(2, new TreeNode(6), new TreeNode(4));
        System.out.println(getDirections(root, 3, 6).equals("UURL"));
        System.out.println(getDirections(new TreeNode(2, new TreeNode(1), null), 2, 1).equals("L"));
        TreeNode harder = new TreeNode();
    }
}
