
public class DriverBT {
	public static void main(String[] args) {
		BinaryTree<String> aTree = new BinaryTree<String>();
		createTree2(aTree);
		// Display root, height, number of nodes
		System.out.println("Root of tree contains data: " + aTree.getRootData());
		System.out.println("Height of tree is " + aTree.getHeight());
		System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");
		// Display nodes in postorder
		System.out.println("A postorder traversal visits nodes in this order:");
		aTree.postorderTraverse();
		System.out.println("\nA postorder traversal visits nodes in this order called from BinaryNode A:");
		aTree.postorderTraverse_callBinaryNodeMethod();
	}
	
	/**
	 * The tree should looks like this:
	 * 
	 *  root -->   A 
	 *            / \ 
	 *           B   C
	 *              / \
	 *             D   E
	 *           /    / \
	 *          F    G   H
	 */
	public static void createTree2(BinaryTree<String> aTree) {
		// Represent each leaf as a one-node tree
		BinaryTreeInterface<String> bTree = new BinaryTree<String>();
		bTree.setTree("B", null, null);
		BinaryTreeInterface<String> fTree = new BinaryTree<String>();
		fTree.setTree("F", null, null);
		BinaryTreeInterface<String> gTree = new BinaryTree<String>();
		gTree.setTree("G", null, null);
		BinaryTreeInterface<String> hTree = new BinaryTree<String>();
		hTree.setTree("H", null, null);

		// Form larger subtrees
		BinaryTreeInterface<String> dTree = new BinaryTree<String>();
		dTree.setTree("D", fTree, null);
		BinaryTreeInterface<String> eTree = new BinaryTree<String>();
		eTree.setTree("E", gTree, hTree);
		
		BinaryTreeInterface<String> cTree = new BinaryTree<String>();
		cTree.setTree("C", dTree, eTree);
		aTree.setTree("A", bTree, cTree); // Desired tree rooted at A
	}
}
