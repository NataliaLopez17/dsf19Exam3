package ciic4020S2Exam3;

public class OnlineWrapper3 {

	public static enum ExpressionType {
		ADD, MINUS, MULT, DIV

	}

	public static interface ExpressionNode {
		public double getValue();
	}

	public static class NumericExpressionNode implements ExpressionNode {

		private double number;

		public NumericExpressionNode(double value) {
			this.number = value;
		}

		public double getValue() {
			return this.number;
		}

		@Override
		public String toString() {
			return this.number + "";
		}

	}

	/*
	 * A Binary Expression Tree implements arithmetic binary expressions. The tree
	 * has nodes of type ExpressionNode, which is an ADT specified with an
	 * interface. Each ExpressionNode can be implemented by either:
	 * NumericExpressionNode - a node that represents a number. This type of node is
	 * implemented as a class. This type of node is a leaf. ComputedExpressionNode -
	 * a node that represents the operation of the sum (+), subtraction (-),
	 * multiplication (x), or division (/). This type of node is an internal binary
	 * node, where the node represents a given operation, and the two children are
	 * of type ExpressionNode A BinaryExpressionTree holds as a private field a
	 * reference to its root. The tree can be constructed in two ways:
	 * 
	 * By giving a number - this creates a tree with a root of that is a
	 * NumericExpressionNode By giving an operation, and two BinaryExpressionTrees -
	 * this creates a root that is a ComputedExpressionNode. The code below
	 * implements these interfaces and classes.
	 * 
	 * (15 pts) Implement the function toString() in the class
	 * ComputedExpressionNode. This function returns the string representation of
	 * the subtree rooted at that node. If the node is a leaf , it returns the
	 * number. Otherwise, it returns a string with parenthesis enclosing the left
	 * hand expression followed by the operator followed by the right hand
	 * expression: (leftHand operator rightHand).
	 */

	public static class ComputedExpressionNode implements ExpressionNode {

		private ExpressionType expType;
		private ExpressionNode leftChild;
		private ExpressionNode rightChild;

		public ExpressionType getExpType() {
			return expType;
		}

		public ExpressionNode getLeftChild() {
			return leftChild;
		}

		public ExpressionNode getRightChild() {
			return rightChild;
		}

		public void setExpType(ExpressionType expType) {
			this.expType = expType;
		}

		public void setLeftChild(ExpressionNode leftChild) {
			this.leftChild = leftChild;
		}

		public void setRightChild(ExpressionNode rightChild) {
			this.rightChild = rightChild;
		}

		public ComputedExpressionNode(ExpressionType expType, ExpressionNode leftChild, ExpressionNode rightChild) {
			super();
			this.expType = expType;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		@Override
		public double getValue() {
			// NOT NEEDED IN THIS QUIZ
			double result = 0.0;
			return result;
		};

		@Override
		public String toString() {
			String result = "";
			// ADD YOUR CODE HERE

			if (this.getLeftChild() == null && this.getRightChild() == null) {
				return this + result;
			} else {
				if (this.getExpType() == ExpressionType.ADD) {
					result = "(" + this.getLeftChild() + " + " + this.getRightChild() + ")";
				}
				if (this.getExpType() == ExpressionType.MINUS) {
					result = "(" + this.getLeftChild() + " - " + this.getRightChild() + ")";
				}
				if (this.getExpType() == ExpressionType.MULT) {
					result = "(" + this.getLeftChild() + " * " + this.getRightChild() + ")";
				}
				if (this.getExpType() == ExpressionType.DIV) {
					result = "(" + this.getLeftChild() + " / " + this.getRightChild() + ")";
				}
			}
			return result;
		}

	}

	public static class BinaryExpressionTree {
		private ExpressionNode root;

		public BinaryExpressionTree(double value) {
			this.root = new NumericExpressionNode(value);
		}

		public BinaryExpressionTree(ExpressionType type, BinaryExpressionTree T1, BinaryExpressionTree T2) {
			this.root = new ComputedExpressionNode(type, T1.root, T2.root);
		}

		public double evaluate() {
			return this.root.getValue();
		}

		@Override
		public String toString() {
			return this.root.toString();
		}
	}
}