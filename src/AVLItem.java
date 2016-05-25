import java.util.LinkedList;

public class AVLItem implements Comparable<AVLItem> {
	
	private String substring;
	private LinkedList<Coordinate> list;
	
	public AVLItem(String substring, Coordinate coord)
	{
		this.substring = substring;
		list.add(coord);
	}
	
	public String getSubstring()
	{
		return substring;
	}
	
	public Coordinate getFirstCoord()
	{
		return list.peekFirst();
	}
	
	public void addToList(AVLItem item)
	{
		list.add(item.getFirstCoord());
	}
	
	public int compareTo(AVLItem other)
	{
		return substring.compareTo(other.getSubstring());
	}
	
}