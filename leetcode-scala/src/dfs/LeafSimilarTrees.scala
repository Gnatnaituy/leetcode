package dfs

import tools.TreeNode

import scala.collection.mutable

object LeafSimilarTrees {

  /**
   * 572 ms   100.00%
   * 52.9 MB  100.00%
   * @param root1
   * @param root2
   * @return
   */
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    val leaves1 = leavesOfTree(root1)
    val leaves2 = leavesOfTree(root2)

    leaves1 sameElements leaves2
  }

  def leavesOfTree(root: TreeNode): Array[Int] = {
    val leaves = new mutable.ArrayBuffer[Int]()

    if (root.left == null && root.right == null) {
      leaves.addOne(root.value)
    } else {
      if (root.left != null) leaves.addAll(leavesOfTree(root.left))
      if (root.right != null) leaves.addAll(leavesOfTree(root.right))
    }

    leaves.toArray
  }

  def main(args: Array[String]): Unit = {
    val root1 = ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(Array.range(0, 10))
    val root2 = ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(Array.range(0, 10))
    val leaves1 = leavesOfTree(root1)
    val leaves2 = leavesOfTree(root2)


    leaves1.map(_ + " ").foreach(print)
    println()
    leaves2.map(_ + " ").foreach(print)
  }
}
