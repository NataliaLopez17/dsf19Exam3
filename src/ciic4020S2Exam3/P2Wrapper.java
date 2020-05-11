package ciic4020S2Exam3;

import java.io.PrintStream;

public class P2Wrapper {
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

		// public int depth(E e);
		public int size();

		public boolean isSymmetric();

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
		 * A Binary Tree is symmetric if and only if for every internal node: a) the
		 * value at the left child is equal to the value at the right child b) the
		 * subtree rooted at the left child is symmetric b) the subtree rooted at the
		 * right child is symmetric.
		 * 
		 * Write a method isSymmetric, which returns true if a tree is symmetric or
		 * false otherwise. An empty tree, or a tree with one node is symmetric by
		 * definition.
		 */

		@Override
		public boolean isSymmetric() {
			return isSymmetricAux(root.leftChild, root.rightChild);

		}

		public boolean isSymmetricAux(BinaryTreeNode<E> node1, BinaryTreeNode<E> node2) {
			if (node1 == null || node2 == null) {
				return true;
			}
			if (node1 != null && node2 != null && node2.getValue() == node1.getValue()) {
				return isSymmetricAux(node1.getLeftChild(), node2.getRightChild())
						&& isSymmetricAux(node1.getRightChild(), node2.getLeftChild());
			} else {
				return false;
			}
		}

		public static void main(String[] args) {
			SimpleBinaryTreeImp<Object> t1 = new SimpleBinaryTreeImp<Object>(null);
			// root
			t1.root = new BinaryTreeNode<Object>(2);
			// left
			t1.root.leftChild = new BinaryTreeNode<Object>(1);
			t1.root.leftChild.parent = t1.root; //

			t1.root.leftChild.leftChild = new BinaryTreeNode<Object>(3);
			t1.root.leftChild.leftChild.parent = t1.root.leftChild; //

			t1.root.leftChild.rightChild = new BinaryTreeNode<Object>(4);
			t1.root.leftChild.rightChild.parent = t1.root.leftChild;

			t1.root.leftChild.rightChild.rightChild = new BinaryTreeNode<Object>(69);
			t1.root.leftChild.rightChild.rightChild.parent = t1.root.leftChild.rightChild;
			// right
			t1.root.rightChild = new BinaryTreeNode<Object>(1);
			t1.root.rightChild.parent = t1.root; //

			t1.root.rightChild.rightChild = new BinaryTreeNode<Object>(3);
			t1.root.rightChild.rightChild.parent = t1.root.rightChild; //

			t1.root.rightChild.leftChild = new BinaryTreeNode<Object>(4);
			t1.root.rightChild.leftChild.parent = t1.root.rightChild;

			t1.root.rightChild.leftChild.leftChild = new BinaryTreeNode<Object>(69);
			t1.root.rightChild.leftChild.leftChild.parent = t1.root.rightChild.leftChild;

			t1.root.leftChild.rightChild.leftChild = new BinaryTreeNode<Object>(40);
			t1.root.leftChild.rightChild.leftChild.parent = t1.root.leftChild.rightChild;

			t1.print(null);
			System.out.println(t1.isSymmetric());

		}

	}
}