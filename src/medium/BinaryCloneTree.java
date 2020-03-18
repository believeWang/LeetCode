package medium;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 Given two binary trees original and cloned and given a reference to a node target in the original tree.

 The cloned tree is a copy of the original tree.

 Return a reference to the same node in the cloned tree.

 Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

 Follow up: Solve the problem if repeated values on the tree are allowed.

 Input: tree = [7,4,3,null,null,6,19], target = 3
 Output: 3
 Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.

 Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 Output: 4

 Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
 Output: 5
 */
public class BinaryCloneTree {

  public static void main(String[] args) {
    Instant start = Instant.now();
    TreeNode head = new TreeNode(7);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(3);
    TreeNode left2 = new TreeNode(6);
    TreeNode right2 = new TreeNode(19);
    head.left = left;
    head.right = right;
    right.left = left2;
    right.right = right2;
    TreeNode cloneHead = new TreeNode(7);
    TreeNode cleft = new TreeNode(4);
    TreeNode cright = new TreeNode(3);
    TreeNode cleft2 = new TreeNode(6);
    TreeNode cright2 = new TreeNode(19);
    cloneHead.left = cleft;
    cloneHead.right = cright;
    cright.left = cleft2;
    cright.right = cright2;
    System.out.println(getTargetCopy(head, cloneHead, right2).val);
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  /**
   * 先找左邊 再找右邊 如果是NULL 代表找到沒有了 往回 或是 相同 代表找到答案
   * @param original
   * @param cloned
   * @param target
   * @return
   */
  private static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {
    System.out.println(Optional.ofNullable(original).map(tree -> tree.val).orElse(null));
    if (original == null || original == target) {
      return cloned;
    }
    TreeNode ansAtLeft = getTargetCopy(original.left, cloned.left, target);
    return Optional.ofNullable(ansAtLeft)
        .orElse(getTargetCopy(original.right, cloned.right, target));

  }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }