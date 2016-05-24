
public class AVLTree {
	
	private AVLTreeNode root;
	
	public AVLTree(AVLTreeNode root)
	{
		this.root = root;
	}
	
	public void insert(AVLTreeNode newNode)
	{
		//TODO
	}
	
	public void delete(AVLTreeNode dNode)
	{
		// Not required in this project
	}
	
	public AVLTreeNode search(Comparable searchKey)
	{
		// TODO
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
		// TODO
		// node의 leftChild의 right subtree에 추가된 경우,
		// left subtree에서 왼쪽 1회전 - 전체에서 오른쪽 1회전
		AVLTreeNode child = node.getLeft();
		node.setLeft(rotate_RR(child));
		AVLTreeNode newRoot = rotate_LL(node);
		return newRoot;
	}
	
	private AVLTreeNode rotate_LR(AVLTreeNode node)
	{
		// TODO
		// node의 rightChild의 left subtree에 추가된 경우,
		// right subtree에서 오른쪽 1회전 - 전체에서 왼쪽 1회전
	}
	
	
}
