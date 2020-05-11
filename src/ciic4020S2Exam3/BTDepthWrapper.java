package ciic4020S2Exam3;

import java.util.ArrayList;
import java.util.List;

public class BTDepthWrapper {

	public static interface TreeNode<E> {
		public E getValue();
	}

	public static class BinaryTreeNode<E> implements TreeNode<E> {

		private E value;
		private BinaryTreeNode<E> leftChild;
		private BinaryTreeNode<E> rightChild;
		private BinaryTreeNode<E> parent;

		public BinaryTreeNode(E value) {
			super();
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;
		}

		public BinaryTreeNode(E value, BinaryTreeNode<E> parent, BinaryTreeNode<E> leftChild,
				BinaryTreeNode<E> rightChild) {
			super();
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}

		@Override
		public E getValue() {
			return this.value;
		}

		public BinaryTreeNode<E> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(BinaryTreeNode<E> leftChild) {
			this.leftChild = leftChild;
		}

		public BinaryTreeNode<E> getRightChild() {
			return rightChild;
		}

		public void setRightChild(BinaryTreeNode<E> rightChild) {
			this.rightChild = rightChild;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public BinaryTreeNode<E> getParent() {
			return parent;
		}

		public void setParent(BinaryTreeNode<E> parent) {
			this.parent = parent;
		}
	}

	public static interface SimpleBinaryTree<E> {

		// get tree root
		public TreeNode<E> root();

		// get left child of node
		public TreeNode<E> left(TreeNode<E> p);

		// get right child of node
		public TreeNode<E> right(TreeNode<E> p);

		// get sibling
		public TreeNode<E> sibling(TreeNode<E> p);

		public boolean isEmpty();

		public int depth(E e);

		public int size();
	}

	public static class SimpleBinaryTreeImp<E> implements SimpleBinaryTree<E> {

		private BinaryTreeNode<E> root;

		public SimpleBinaryTreeImp(BinaryTreeNode<E> root) {
			super();
			this.root = root;
		}

		public SimpleBinaryTreeImp(BinaryTreeNode<E> root, SimpleBinaryTree<E> T1, SimpleBinaryTree<E> T2) {
			super();
			this.root = root;
			if (T1 != null) {
				BinaryTreeNode<E> temp = (BinaryTreeNode<E>) T1.root();
				this.root.setLeftChild(temp);
				temp.setParent(this.root);

			}
			if (T2 != null) {
				BinaryTreeNode<E> temp = (BinaryTreeNode<E>) T2.root();

				this.root.setRightChild(temp);
				temp.setParent(this.root);
			}
		}

		@Override
		public TreeNode<E> root() {
			return this.root;
		}

		private void check(TreeNode<E> p) {
			if (p == null) {
				throw new IllegalArgumentException();
			}
		}

		@Override
		public TreeNode<E> left(TreeNode<E> p) {
			this.check(p);
			BinaryTreeNode<E> temp = (BinaryTreeNode<E>) p;
			return temp.getLeftChild();
		}

		@Override
		public TreeNode<E> right(TreeNode<E> p) {
			this.check(p);
			BinaryTreeNode<E> temp = (BinaryTreeNode<E>) p;
			return temp.getRightChild();

		}

		@Override
		public TreeNode<E> sibling(TreeNode<E> p) {
			this.check(p);
			BinaryTreeNode<E> temp = (BinaryTreeNode<E>) p;
			if (temp.getParent().getLeftChild() != temp) {
				return temp.getRightChild();
			} else {
				return temp.getLeftChild();
			}
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public int size() {
			return this.sizeAux(this.root);
		}

		private int sizeAux(BinaryTreeNode<E> N) {
			if (N == null)
				return 0;
			else
				return 1 + this.sizeAux(N.getLeftChild()) + this.sizeAux(N.getRightChild());
		}

		public void print() {
			this.printAux(this.root, 0);
		}

		private void printAux(BinaryTreeNode<E> N, int i) {
			if (N != null) {
				this.printAux(N.getRightChild(), i + 4);
				for (int j = 0; j < i; ++j) {
					System.out.print(" ");
				}
				System.out.println(N.getValue());
				this.printAux(N.getLeftChild(), i + 4);
			}
		}

		private BinaryTreeNode<E> find(E e, BinaryTreeNode<E> N) {
			if (N == null)
				return null;
			else if (N.getValue().equals(e))
				return N;
			else {
				BinaryTreeNode<E> temp = find(e, N.getLeftChild());
				if (temp != null)
					return temp;
				else
					return find(e, N.getRightChild());
			}
		}

		@Override
		public int depth(E e) {
			if (this.root == null) {
				return -1;
			}
			if (this.isEmpty()) {
				return -1;
			}
			return depthAux(e, root);
		}

		public int depthAux(E e, BinaryTreeNode<E> N) {
			int count = 0;
			if (N == null)
				return -1;
			else if (N.getValue().equals(e))
				return count;
			else {
				if (depthAux(e, N.getLeftChild()) != -1) {
					count++;
				}
				if (depthAux(e, N.getRightChild()) != -1) {
					count++;
				}
			}
			return count;

		}

		//////////////////////////////////////////////////////////////////
		// Returns the total number of leaves in the BST.
		// The method returns 0 if the tree is empty.
		// Also, if the tree only has one node, then it returns 1.
		public int leafCount() {

			if (this.root == null) {
				return 0;
			}
			if (this.size() == 1) {
				return 1;
			} else {
				return leafCountAux(this.root);
			}
		}

		public int leafCountAux(BinaryTreeNode<E> N) {
			if (N == null) {
				return 0;
			}
			if (N.getLeftChild() == null && N.getRightChild() == null) {
				return 1;
			}
			return leafCountAux(N.getLeftChild()) + leafCountAux(N.getRightChild());
		}

		//////////////////////////////////////////////////////////////////
		// Returns an iterable (e.g., an ArrayList) with all the nodes that are internal
		////////////////////////////////////////////////////////////////// nodes.
		// The nodes are returned as they would be visited in a pre-order traversal.
		// The method returns an empty list if the tree is empty, or if it only has one
		////////////////////////////////////////////////////////////////// node.
		public Iterable<BinaryTreeNode<E>> internals() {
			List<BinaryTreeNode<E>> L = new ArrayList<BinaryTreeNode<E>>(this.size());
			// ADD YOUR CODE HERE

			// CHANGE THIS RETURN VALUE
			return null;

		}

		//////////////////////////////////////////////////
		// FOR STUDENTS
		// Find the positions that form the path from root to first
		// copy of e in the tree. The value is search for in pre-order.
		// Asume e has method equals() implemented correctly.
		// Returns a list of positions from root to e.
		// Returns empty list if e is not found.
		public List<TreeNode<E>> getPath(E e) {
			List<TreeNode<E>> L = new ArrayList<TreeNode<E>>();
			TreeNode<E> p = this.root();
			return this.getPathAux(p, e, L);

		}

		public List<TreeNode<E>> getPathAux(TreeNode<E> p, E e, List<TreeNode<E>> L) {
			if (p == null)
				return L;
			else {
				if (p.getValue().equals(e)) {
					L.add(p);

				} else {
					getPathAux(left(p), e, L);
					getPathAux(right(p), e, L);
				}
				return L;
			}

		}

	}
}