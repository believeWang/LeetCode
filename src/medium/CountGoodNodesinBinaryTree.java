package medium;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * 5398. Count Good Nodes in Binary Tree
 Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

 Return the number of good nodes in the binary tree.



 Example 1:



 Input: root = [3,1,4,3,null,1,5]
 Output: 4
 Explanation: Nodes in blue are good.
 Root Node (3) is always a good node.
 Node 4 -> (3,4) is the maximum value in the path starting from the root.
 Node 5 -> (3,4,5) is the maximum value in the path
 Node 3 -> (3,1,3) is the maximum value in the path.
 Example 2:



 Input: root = [3,3,null,4,2]
 Output: 3
 Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 Example 3:

 Input: root = [1]
 Output: 1
 Explanation: Root is considered as good.


 Constraints:

 The number of nodes in the binary tree is in the range [1, 10^5].
 Each node's value is between [-10^4, 10^4].
 */
public class CountGoodNodesinBinaryTree {

  public static void main2(String[] args) {
    Instant start = Instant.now();
    TreeNode head = new TreeNode(3);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(4);
    TreeNode left2 = new TreeNode(3);
    TreeNode left3 = new TreeNode(1);
    TreeNode right2 = new TreeNode(5);
    head.left = left;
    head.right = right;
    left.left = left2;
    right.right = right2;
    right.left = left3;
    System.out.println(goodNodes(head));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }
  public static void main(String[] args) {
    Instant start = Instant.now();
    TreeNode head = new TreeNode(3);
    TreeNode left = new TreeNode(3);
    TreeNode left2 = new TreeNode(4);
    TreeNode right2 = new TreeNode(2);
    head.left = left;
    left.left = left2;
    left.right = right2;
    System.out.println(goodNodes(head));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  private static int goodNodes(TreeNode root) {


    return findGood(root, root.val);
  }

  private static int findGood(TreeNode root, int value) {
    int cnt = 0 ;
    if (root == null) return 0;
    if (root.val >= value) {
      value = root.val;
      cnt ++;
    }
    return findGood(root.left, value) + findGood(root.right, value) + cnt;
  }
}
