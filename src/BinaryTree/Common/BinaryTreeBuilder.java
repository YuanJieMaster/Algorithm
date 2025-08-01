package BinaryTree.Common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 根据输入构建一棵二叉树
 * 输入示例：[3,9,20,null,null,15,7]
 */
public class BinaryTreeBuilder {
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (index < nodes.length && nodes[index] != null) {
                current.left = new TreeNode(nodes[index]);
                queue.offer(current.left);
            }
            index++;

            // 处理右子节点
            if (index < nodes.length && nodes[index] != null) {
                current.right = new TreeNode(nodes[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(input);

        // 打印验证
        printTree(root);
    }

    // 辅助方法：打印二叉树（层序遍历）
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("[");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                System.out.print("null,");
            }
        }
        System.out.println("]");
    }
}