import java.lang.Math;

public class AVLTreeNode {
	
	private AVLItem item;
	private AVLTreeNode leftChild;
	private AVLTreeNode rightChild;
	private int leftHeight;
	private int rightHeight;
	private int heightDiff; // leftHeight-rightHeight
	
	public AVLTreeNode(AVLItem newItem)
	{
		this.item = newItem;
		this.leftChild = this.rightChild = null;
		leftHeight = 0;
		rightHeight = 0;
		heightDiff = 0;
	}
	
	public AVLTreeNode(AVLItem newItem, AVLTreeNode leftChild, AVLTreeNode rightChild)
	{
		this.item = newItem;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public AVLItem getItem()
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
	
	public void setItem(AVLItem newItem)
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
