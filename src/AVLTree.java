public class AVLTree {
	
	private AVLTreeNode root;
	
	public AVLTree()
	{
		this.root = null;
	}
	
	public AVLTree(AVLTreeNode root)
	{
		this.root = root;
	}
	
	public void insert(AVLItem newItem)
	{
		// copy from lecture 11 slide
		root = insertItem(root, newItem);
	}
	
	public AVLItem search(String searchKey)
	{
		AVLTreeNode result = searchItem(root, searchKey);
		if (result != null)
			return result.getItem();
		
		else
			return null;
	}
	
	public void delete(AVLTreeNode dNode)
	{
		// Not required in this project
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public String preorder_traversal()
	{
		if (root == null)
			return "EMPTY";
		
		String traversal = preorder_traversal(new String(), root);
		
		return traversal.substring(0, traversal.length()-1); // leave out last " "
	}
	
	private String preorder_traversal(String traversal, AVLTreeNode rootNode)
	{
		// FIXME
		if (rootNode != null)
		{
			traversal = traversal + rootNode.getItem().getSubstring() + " ";
			traversal = preorder_traversal(traversal, rootNode.getLeft());
			traversal = preorder_traversal(traversal, rootNode.getRight());
		}
		
		return traversal;
	}
	
	private AVLTreeNode insertItem(AVLTreeNode rootNode, AVLItem newItem)
	{
		// modification from lecture 11 slide 
		if (rootNode == null)
		{
			rootNode = new AVLTreeNode(newItem);
		}
		
		else if (newItem.compareTo(rootNode.getItem()) < 0)
		{
			rootNode.setLeft(insertItem(rootNode.getLeft(), newItem));
			rootNode = balance(rootNode);
		}
			
		else if (newItem.compareTo(rootNode.getItem()) > 0)
		{
			rootNode.setRight(insertItem(rootNode.getRight(), newItem));
			rootNode = balance(rootNode);
		}
		
		else // 같은 substring을 갖는 item이 있을시 list 뒤에 좌표를 추가한다.
		{
			rootNode.getItem().addToList(newItem);
		}
		
		return rootNode;
	}
	
	private AVLTreeNode searchItem(AVLTreeNode rootNode, String searchKey)
	{
		// modification from lecture 11 slide
		if (rootNode == null)
			return null;

		else
		{
			int comparison = rootNode.getItem().getSubstring().compareTo(searchKey);
			
			if (comparison > 0)
				return searchItem(rootNode.getLeft(), searchKey);
			
			else if (comparison < 0)
				return searchItem(rootNode.getRight(), searchKey);
			
			else
				return rootNode;
		}
	}
	
	private AVLTreeNode balance(AVLTreeNode node)
	{
		int heightDiff = node.get_heightDiff(); // leftHeight - rightHeight
		int subHeightDiff;
		
		if (heightDiff < -1) // right subtree가 더 높다 (높이 차가 2 이상 - unbalanced)
		{
			subHeightDiff = node.getRight().get_heightDiff();
			
			if (subHeightDiff > 0) // rightChild의 left subtree
				node = rotate_RL(node);
			
			else if (subHeightDiff < 0)// rightChild의 right subtree
				node = rotate_RR(node);
		}
		
		else if (heightDiff > 1) // left subtree가 더 높다 (높이 차가 2 이상 - unbalanced)
		{
			subHeightDiff = node.getLeft().get_heightDiff();
			
			if (subHeightDiff > 0) // leftChild의 left subtree
				node = rotate_LL(node);
			
			else if (subHeightDiff < 0) // leftChild의 right subtree
				node = rotate_LR(node);
		}
		
		return node;
	}
	
	private AVLTreeNode rotate_LL(AVLTreeNode node)
	{
		// node의 leftChild의 left subtree에 추가된 경우, 오른쪽으로 1회전 
		// leftChild의 right subtree를 node의 leftChild로 만듦
		// node를 원래 leftChild의 rightChild로 만듦
		// 회전으로 인해 root가 된 child를 return
		AVLTreeNode child = node.getLeft();
		node.setLeft(child.getRight()); 
		child.setRight(node);
		return child;
	}
	
	private AVLTreeNode rotate_RR(AVLTreeNode node)
	{
		// node의 rightChild의 right subtree에 추가된 경우, 왼쪽으로 1회전
		// rightChild의 left subtree를 node의 rightChild로 만듦
		// node를 원래 rightChild의 leftChild로 만듦
		// 회전으로 인해 root가 된 node를 return
		AVLTreeNode child = node.getRight();
		node.setRight(child.getLeft());
		child.setLeft(node);
		return child;
	}
	
	private AVLTreeNode rotate_LR(AVLTreeNode node)
	{
		// node의 leftChild의 right subtree에 추가된 경우,
		// left subtree에서 왼쪽 1회전 - 전체에서 오른쪽 1회전
		AVLTreeNode child = node.getLeft();
		node.setLeft(rotate_RR(child));
		AVLTreeNode newRoot = rotate_LL(node);
		return newRoot;
	}
	
	private AVLTreeNode rotate_RL(AVLTreeNode node)
	{
		// node의 rightChild의 left subtree에 추가된 경우,
		// right subtree에서 오른쪽 1회전 - 전체에서 왼쪽 1회전
		AVLTreeNode child = node.getRight();
		node.setRight(rotate_LL(child));
		AVLTreeNode newRoot = rotate_RR(node);
		return newRoot;
	}
	
	
}
