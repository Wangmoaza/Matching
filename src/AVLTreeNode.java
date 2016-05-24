import java.lang.Math;

public class AVLTreeNode<T extends Comparable<T>> {
	
	private T item;
	private AVLTreeNode<T> parent;
	private AVLTreeNode<T> leftChild;
	private AVLTreeNode<T> rightChild;
	private int leftHeight;
	private int rightHeight;
	private int heightDiff; // leftHeight-rightHeight
	
	public AVLTreeNode(T newItem)
	{
		this.item = newItem;
		this.parent = this.leftChild = this.rightChild = null;
		leftHeight = 0;
		rightHeight = 0;
		heightDiff = 0;
	}
	
	public AVLTreeNode(T newItem, AVLTreeNode<T> leftChild, AVLTreeNode<T> rightChild)
	{
		this.item = newItem;
		this.parent = null;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public AVLTreeNode(T newItem, AVLTreeNode<T> parent, AVLTreeNode<T> leftChild, AVLTreeNode<T> rightChild)
	{
		this.item = newItem;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public T getItem()
	{
		return item;
	}
	
	public AVLTreeNode<T> getRight()
	{
		return rightChild;
	}
	
	public AVLTreeNode<T> getLeft()
	{
		return leftChild;
	}
	
	public AVLTreeNode<T> getParent()
	{
		return parent;
	}
	
	public void setItem(T newItem)
	{
		this.item = newItem;
	}
	
	public void setLeft(AVLTreeNode<T> left)
	{
		leftChild = left;
	}
	
	public void setRight(AVLTreeNode<T> right)
	{
		rightChild = right;
	}
	
	public void setParent(AVLTreeNode<T> parent)
	{
		this.parent = parent;
	}
	
	private int height(AVLTreeNode<T> node)
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
