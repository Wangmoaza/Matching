public class HashTable {
	private static final int TABLE_SIZE = 100;
	private AVLTree[] table;
	
	public HashTable()
	{
		table = new AVLTree[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			AVLTree item = new AVLTree();
			table[i] = item;
		}
	}
	
	public void clear()
	{
		table = new AVLTree[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			AVLTree item = new AVLTree();
			table[i] = item;
		}
	}
	
	private int hash(String str)
	{
		char[] charArray = str.toCharArray();
		int sum = 0;
		
		for (char ch : charArray)
		{
			sum += (int) ch;
		}
		
		return sum % TABLE_SIZE;
	}
	
	public void put(String key, AVLItem value)
	{
		table[hash(key)].insert(value);
	}
	
	public AVLTree search(String key)
	{
		return table[hash(key)];
	}
	
	public void remove(String key)
	{
		// not required in this project
	}
	
	public boolean containsKey(String key)
	{
		return !(table[hash(key)].isEmpty());
	}
	
	public void print(int index)
	{
		System.out.println(table[index].preorder_traversal());
	}
	
}