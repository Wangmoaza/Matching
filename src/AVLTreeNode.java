import java.util.LinkedList;

public class AVLTreeNode {
	
	private AVLitem item;
	private AVLTreeNode leftChild;
	private AVLTreeNode rightChild;
	private int leftHeight;
	private int rightHeight;
	private int heightDiff;
	
	public AVLTreeNode()
	{
		
	}
	
	class AVLitem implements Comparable<AVLitem>
	{
		private String substring;
		private LinkedList<Coordinate> list;
		
		public AVLitem(String substring, Coordinate coord)
		{
			this.substring = substring;
			list.add(coord);
		}
		
		public String getString()
		{
			return substring;
		}
		
		public int compareTo(AVLitem other)
		{
			return substring.compareTo(other.getString());
		}
	}
	
	class Coordinate implements Comparable<Coordinate>
	{
		private int line;
		private int place;
		
		public Coordinate(int line, int place)
		{
			this.line = line;
			this.place = place;
		}
		
		public int getLine()
		{
			return line;
		}
		
		public int getPlace()
		{
			return place;
		}
		
		public int compareTo(Coordinate other)
		{
			if (line != other.getLine())
				return line > other.getLine() ? 1 : -1;
			
			else if (place != other.getPlace())
				return place > other.getPlace() ? 1 : -1;
			
			else
				return 0;	
		}
		
		@Override
		public String toString()
		{
			return "(" + line + ", " + place + ")";
		}
	}
}
