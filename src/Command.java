import java.io.*;
import java.lang.Integer;

public interface Command
{
	// modification from MovieDB skeleton code
	static int SUBSTR_LEN = 6;
	
	void parse(String input);
	void apply(HashTable ht) throws Exception;
}

class InputCmd implements Command {
	
	private String fileName;
	
	public void parse(String input)
	{
		// System.out.println("parse");
		String[] args = input.split(" "); // "<" 와  fileName 으로 나뉜다
		fileName = args[1];	
		// System.out.println("parse done");
	}
	
	public void apply(HashTable ht)
	{
		ht.clear(); // clear earlier data
		
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int lineNum = 1;

			String thisLine = br.readLine();
			while (thisLine != null) // read each line
			{
				for (int i = 0; i < thisLine.length() - SUBSTR_LEN + 1; i++) // parse to substrings
				{
					String substr = thisLine.substring(i, i + SUBSTR_LEN);
					Coordinate coord = new Coordinate(lineNum, i+1); // 1 부터 시작
					AVLItem item = new AVLItem(substr, coord);
					//System.out.println(coord.toString() + " " + item.getSubstring());
					ht.put(substr, item); // add to hashtable
				}

				thisLine = br.readLine();
				lineNum++;
			}
			
			br.close();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class PrintCmd implements Command {
	private int index;
	
	public void parse(String input)
	{
		String args[] = input.split(" "); // "@"와 index number로 나뉜다
		index = Integer.parseInt(args[1]);
	}
	
	public void apply(HashTable ht)
	{
		ht.print(index);
	}
}

class PatternCmd implements Command {
	private String pattern;
	private String[] subPatterns;
	private int overlap;
	
	public void parse(String input)
	{
		pattern = input.substring(2);
		int num;
		
		// determine subPattern array size
		if (pattern.length() % SUBSTR_LEN == 0)
			num = pattern.length() / SUBSTR_LEN;
		
		else
			num = (pattern.length() / SUBSTR_LEN) + 1;
		
		subPatterns = new String[num];
		int index;
		
		for (index = 0; index < subPatterns.length - 1; index++)
		{
			subPatterns[index] = pattern.substring(6 * index, 6 * index + SUBSTR_LEN);
		}
		
		// handle leftover, 남은 길이에 따라 이전 subpattern과 겹치게 된다.
		subPatterns[index] = pattern.substring(pattern.length() - SUBSTR_LEN);
		overlap = (SUBSTR_LEN - (pattern.length() % SUBSTR_LEN)) % SUBSTR_LEN;
		System.out.println("overlap: " + overlap);
	}
	
	public void apply(HashTable ht)
	{
		System.out.println("array length: " + subPatterns.length);
		
		AVLItem baseItem = ht.search(subPatterns[0]).search(subPatterns[0]);
		baseItem.resetAllFlags(); // 모두 true로 setting
		int i;
		
		for (i = 1; i < subPatterns.length - 1; i++)
		{
			AVLItem currItem = ht.search(subPatterns[i]).search(subPatterns[i]);
			System.out.println(currItem.getSubstring());
			for (Coordinate coord : currItem.getList())
			{
				for (Coordinate baseCoord : baseItem.getList())
				{
					if (baseCoord.getFlag()) // true 일때만
					{
						baseCoord.setFlag(baseCoord.nearTo(coord, SUBSTR_LEN * i));
						System.out.println(baseCoord.getFlag());
					}
				}
			}
			
		}
		
		// 마지막 substring 처리
		if (subPatterns.length != 1)
		{
			int last = subPatterns.length - 1;
			AVLItem currItem = ht.search(subPatterns[last]).search(subPatterns[last]);
			for (Coordinate baseCoord : baseItem.getList())
			{
				for (Coordinate currCoord : currItem.getList())
				{
					// FIXME
					System.out.println(baseCoord.toString() + " " + baseCoord.getFlag());
					System.out.println("coord: " + currCoord.toString());
					if (baseCoord.getFlag()) // true 일때만
					{
						//System.out.println(SUBSTR_LEN * i - overlap);
						baseCoord.setFlag(baseCoord.nearTo(currCoord, SUBSTR_LEN * i - overlap ));
					}
				}
			}
		}
		String result = "";
		// baseItem에서 pattern과 일치하는 것만 true flag
		for (Coordinate baseCoord : baseItem.getList())
		{
			// FIXME
			if (baseCoord.getFlag())
				result += baseCoord.toString() + " ";
				
		}
		
		if (!result.isEmpty())
			System.out.println(result.substring(0, result.length()-1));
		else
			System.out.println("(0, 0)");
	}
}
