public class Coordinate implements Comparable<Coordinate>
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
		
		public boolean nearTo(Coordinate other, int offset)
		{
			return (line == other.getLine()) && (other.getPlace() == (place + offset));
		}
		
		@Override
		public String toString()
		{
			return "(" + line + ", " + place + ")";
		}
	}
