import java.lang.Math;

// parent field를 없애야하나?
public class AVLTreeNode {
	
	private Object item;
	private AVLTreeNode parent;
	private AVLTreeNode leftChild;
	private AVLTreeNode rightChild;
	private int leftHeight;
	private int rightHeight;
	private int heightDiff; // leftHeight-rightHeight
	
	public AVLTreeNode(Object newItem)
	{
		this.item = newItem;
		this.parent = this.leftChild = this.rightChild = null;
		leftHeight = 0;
		rightHeight = 0;
		heightDiff = 0;
	}
	
	public AVLTreeNode(Object newItem, AVLTreeNode leftChild, AVLTreeNode rightChild)
	{
		this.item = newItem;
		this.parent = null;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public AVLTreeNode(Object newItem, AVLTreeNode parent, AVLTreeNode leftChild, AVLTreeNode rightChild)
	{
		this.item = newItem;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public Object getItem()
	{
		return item;
	}
	
	public AVLTreeNode getRight()
	{
		return rightChild;
	}
	
	public AVLTreeNode getLeft()
	{
		return leftChild;
	}
	
	public AVLTreeNode getParent()
	{
		return parent;
	}
	
	public void setItem(Object newItem)
	{
		this.item = newItem;
	}
	
	public void setLeft(AVLTreeNode left)
	{
		leftChild = left;
	}
	
	public void setRight(AVLTreeNode right)
	{
		rightChild = right;
	}
	
	public void setParent(AVLTreeNode parent)
	{
		this.parent = parent;
	}
	
	private int height(AVLTreeNode node)
	{
		int height = 0;
		if (node != null)
			height = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		
		return height;
	}
	
	public int get_heightDiff()
	{
		leftHeight = height(leftChild);
		rightHeight = height(rightChild);
		heightDiff = leftHeight - rightHeight;
		return heightDiff;
	}
}
