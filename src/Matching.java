import java.io.*;

public class Matching
{
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashTable ht = new HashTable();
		
		while (true)
		{
			try
			{
				String input = br.readLine();
				if (input.compareTo("QUIT") == 0)
					break;

				command(ht, input);
			}
			catch (IOException e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
		}
	}

	private static void command(HashTable ht, String input)
	{
		// Modification from MovieDB skeleton code
		try
		{
			Command command = null;
			
			if (input.startsWith("<")) 
				command = new InputCmd();
			
			else if (input.startsWith("@"))
				command = new PrintCmd();
			
			else if (input.startsWith("?"))
				command = new PatternCmd();
			
			command.parse(input);
			command.apply(ht);
		}
		
		catch (Exception e)
		{
			System.out.println("Error in command");
			e.printStackTrace();
		}
	}
}