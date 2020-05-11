package ciic4020S2Exam3;

import java.io.PrintStream;

public class P1Wrapper {
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

		//
		public boolean isEmpty();

		public int size();

		public int oneChildCount();

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
			// ADD YOUR CODE HERE
			return this.sizeAux(this.root);

			// return 0;
		}

		private int sizeAux(BinaryTreeNode<E> N) {
			if (N == null) {
				return 0;
			} else {
				return 1 + this.sizeAux(N.getLeftChild()) + this.sizeAux(N.getRightChild());
			}

		}

		public void print(PrintStream out) {
			this.printAux(this.root, 0, out);
		}

		private void printAux(BinaryTreeNode<E> N, int i, PrintStream out) {
			if (N != null) {
				this.printAux(N.getRightChild(), i + 4, out);
				for (int j = 0; j < i; ++j) {
					System.err.print(" ");
				}
				System.err.println(N.getValue());
				this.printAux(N.getLeftChild(), i + 4, out);
			}

		}

		private BinaryTreeNode<E> find(E e, BinaryTreeNode<E> N) {
			if (N == null) {
				return null;
			} else if (N.getValue().equals(e)) {
				return N;
			} else {
				BinaryTreeNode<E> temp = find(e, N.getLeftChild());
				if (temp != null) {
					return temp;
				} else {
					return find(e, N.getRightChild());
				}
			}
		}
		//////////////////////////////////////////////////
		// For Students
		//
		/*
		 * Write a method that returns the number of internal nodes that only have one
		 * child in a binary tree. If the tree is empty, or if the tree has only one
		 * node then the method returns 0.
		 * 
		 */

		@Override
		public int oneChildCount() {
			if (this.isEmpty()) {
				return 0;
			}
			if (this.root == null) {
				return 0;
			}
			if (this.root.getLeftChild() == null || this.root.getRightChild() == null) {
				return 0;
			}

			return oneChildCountAux(root);
		}

		public int oneChildCountAux(BinaryTreeNode<E> N) {
			int count = 0;
			if (this.isEmpty()) {
				return 0;
			}
			if (N.getLeftChild() != null && N.getRightChild() != null) {
				count = 1;
				if (N.getLeftChild() != null) {
					count += oneChildCountAux(N.getLeftChild());
				} else if (N.getRightChild() != null) {
					count += oneChildCountAux(N.getRightChild());
				}
			}
			return count;
		}

		public static void main(String[] args) {
			SimpleBinaryTreeImp<Integer> T1 = new SimpleBinaryTreeImp<Integer>(null);
			T1.root = new BinaryTreeNode<Integer>(1);
			T1.root.leftChild = new BinaryTreeNode<Integer>(2);
			T1.root.rightChild = new BinaryTreeNode<Integer>(2);
			T1.root.leftChild.leftChild = new BinaryTreeNode<Integer>(3);
			T1.root.leftChild.rightChild = new BinaryTreeNode<Integer>(4);
			T1.root.rightChild.leftChild = new BinaryTreeNode<Integer>(4);
			T1.root.rightChild.rightChild = new BinaryTreeNode<Integer>(3);

			System.out.println(T1.oneChildCount());

		}
	}

}