
public interface BinaryTreeInterface <T> extends TreeInterface <T>{
	
	/**
	 * Sets the data in the root of this binary tree
	 * 
	 * @param rootData The data for the root
	 */
	public void setRootData(T rootData);

	/**
	 * Sets the new binary tree.
	 * 
	 * @param rootData  The data for the root
	 * @param leftTree  The left subtree
	 * @param rightTree The right subtree
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
