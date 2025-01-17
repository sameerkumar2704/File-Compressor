package Alogrithm;

public class TreeNode {

    public char c;
    public Integer count;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Character word, Integer count) {
        this.c = word;
        this.count = count;
        this.left = null;
        this.right = null;
    }

    public TreeNode(Character word, Integer count, TreeNode left, TreeNode right) {
        this.c = word;
        this.count = count;
        this.left = left;
        this.right = right;
    }

}
