

public class BinaryTree <T>implements BinaryTreeInterface<T> {
	
	private BinaryNode<T> root;

	public void postorderTraverse() {
		postorderTraverse(root);
	}

	private void postorderTraverse(BinaryNode<T> node) {
		// return if the current node is empty
		if (node == null) {
			return;
		}
		// Traverse the left subtree
		postorderTraverse(node.getLeftChild());

		// Traverse the right subtree
		postorderTraverse(node.getRightChild());

		// Display the data part of the current node
		System.out.print(node.getData() + " ");
	}

	public void postorderTraverse_callBinaryNodeMethod() {
		root.postorderTraverse_binaryNodeMethod();
	}

	public void setRootData(T rootData) {
		root.setData(rootData);
	}

	public T getRootData() {
		if (isEmpty()) {
			throw new EmptyTreeException();
		} else {
			return root.getData();
		}
	}

	public void setTree(T rootData, BinaryTreeInterface<T> left, BinaryTreeInterface<T> right) {
		root = new BinaryNode<T>(rootData);
		BinaryTree<T> leftTree = (BinaryTree<T>) left;
		BinaryTree<T> rightTree = (BinaryTree<T>) right;

		if (leftTree != null && !leftTree.isEmpty()) {
			root.setLeftchild(leftTree.root);
		}
		if (rightTree != null && !rightTree.isEmpty()) {
			if (rightTree != leftTree) {
				root.setRightChild(rightTree.root);
			} else {
				root.setRightChild(rightTree.root.copy());
			}
		}

	}

	public int getHeight() {
		return root == null ? 0 : root.getHeight();
	}

	public int getNumberOfNodes() {
		return getNumberOfNodes(root);
	}

	private int getNumberOfNodes(BinaryNode<T> top) {
		return top == null ? 0 : 1 + getNumberOfNodes(top.getLeftChild()) + getNumberOfNodes(top.getRightChild());
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}
}

