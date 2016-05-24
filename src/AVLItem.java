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
	
	public int compareTo(AVLItem other)
	{
		return substring.compareTo(other.getSubstring());
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
