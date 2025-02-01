package kk.sets;

/**
 * TreeSet<>() is essentially an implementation of BST where each node can have at most 2 child nodes, left_node < cur_node < right_node.
 * All child node can potentially be a sub-tree. For a given cur_node, (all elements on left sub-tree) < cur_node < (all elements on right sub-tree)
 * add(), remove(), contains(), all 3 happens at O(log N) time. Because, add() and remove() first checks if element is present or not (contains), and then perform node deletion|addition.
 * removal of node: If node to be removed is leaf node, then it's easy to remove. If it's parent node, then that parent node is replaced by either the largest
 * element from left child sub-tree (rightmost in left sub-tree),
 * or smallest element of right child sub-tree (leftmost in right sub-tree).
 * Since, arrangement of element is based totally on comparison, hence element type of TreeSet must have compareTo() overridden from Comparable interface.
 * Also, compareTo() & equals() must be consistent.
 * Internally uses TreeMap, same complexity. It canNOT store null values.
 * We can give comparator also in the constructor of the treeSet.
 */

/**
 * Balanced BST is where cardinality of nodes in left and right sub-tree are same. Imbalance to balance conversion (re-shuffling of nodes) happens in O(Log N) time.
 * eg, inserting st. increasing elements will result in making a LL, an imbalanced BST.
 */
public class TreeSets {
}
