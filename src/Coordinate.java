public class Coordinate implements Comparable<Coordinate>
	{
		private int line;
		private int place;
		private boolean flag; // pattern 찾을때 활용
		
		public Coordinate(int line, int place)
		{
			this.line = line;
			this.place = place;
			this.flag = true;
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
		
		public void setFlag(boolean flag)
		{
			this.flag = flag;
		}
		
		public boolean getFlag()
		{
			return flag;
		}
		
		public void resetFlag()
		{
			flag = true;
		}
		
		@Override
		public String toString()
		{
			return "(" + line + ", " + place + ")";
		}
	}
