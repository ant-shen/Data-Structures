
public class BinaryNode <T> {
	
	private T data; 
	private BinaryNode <T> leftChild; 
	private BinaryNode <T> rightChild;
	
	public BinaryNode() {
		this(null);
	}
	public BinaryNode(T dataPortion) {
		this(dataPortion, null, null); 
	}
	
	public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
		data = dataPortion; 
		leftChild = newLeftChild; 
		rightChild = newRightChild; 
	}
	
	
	public void postorderTraverse_binaryNodeMethod() {
		postorderTraverse_binaryNodeMethod(this);
	}
	
	public void postorderTraverse_binaryNodeMethod(BinaryNode<T> top) {
		//// return if the current node is empty
		if(top == null) {
			return;
		}
        // Traverse the left subtree
		postorderTraverse_binaryNodeMethod(top.getLeftChild());
    
        // Traverse the right subtree
		postorderTraverse_binaryNodeMethod(top.getRightChild());
    
        // Display the data part of the current node)
        System.out.print(top.getData() + " ");
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftchild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	} 
	
	
	public boolean hasLeftChild() {
		return leftChild != null; 
	}
	
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	public int getHeight() {
		return getHeight(this);
	}

	public int getHeight(BinaryNode<T> top) {
		return top == null ? 0 : 1 + Math.max(getHeight(top.getLeftChild()), getHeight(top.getRightChild()));
	}

	public int getNumberOfNodes() {
		return getNumberOfNodes(this);
	}

	public int getNumberOfNodes(BinaryNode<T> top) {
		return top == null ? 0 : 1 + getNumberOfNodes(top.leftChild) + getNumberOfNodes(top.rightChild);
	}

	public BinaryNode<T> copy() {
		BinaryNode<T> copy = new BinaryNode<T>(data);
		if (leftChild != null) {
			copy.setLeftchild(leftChild.copy());
		}
		if (rightChild != null) {
			copy.setRightChild(rightChild.copy());
		}
		return copy;
	}
}
