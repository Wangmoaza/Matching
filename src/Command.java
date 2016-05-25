import java.io.*;
import java.lang.Integer;

public interface Command
{
	// modification from MovieDB skeleton code
	static int SUBSTRING_LEN = 6;
	
	void parse(String input);
	void apply(HashTable ht) throws Exception;
}

class InputCmd implements Command {
	
	private String fileName;
	
	public void parse(String input)
	{
		String[] args = input.split(" "); // "<" 와  fileName 으로 나뉜다
		fileName = args[1];	
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
				for (int i = 0; i < thisLine.length() - SUBSTRING_LEN + 1; i++) // parse to substrings
				{
					String substr = thisLine.substring(i, i + SUBSTRING_LEN);
					Coordinate coord = new Coordinate(lineNum, i+1); // 1 부터 시작
					AVLItem item = new AVLItem(substr, coord);
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
		int num = (pattern.length() / SUBSTRING_LEN) + 1;
		subPatterns = new String[num];
		int index;
		
		for (index = 0; index < subPatterns.length - 1; index++)
		{
			subPatterns[index] = pattern.substring(6 * index, 6 * index + SUBSTRING_LEN);
		}
		
		// handle leftover, 남은 길이에 따라 이전 subpattern과 겹치게 된다.
		subPatterns[index] = pattern.substring(pattern.length() - SUBSTRING_LEN);
		overlap = (SUBSTRING_LEN - (pattern.length() % SUBSTRING_LEN)) % SUBSTRING_LEN;
	}
	
	public void apply(HashTable ht)
	{
		
	}
}
