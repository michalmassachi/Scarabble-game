package test;

import java.util.HashMap;
import java.util.Map;

public class DictionaryManager {

	private static DictionaryManager cm=null;
	Map<String, Dictionary> map= new HashMap<String, Dictionary>();
	
	private DictionaryManager(){}

	
	
	
	
	public boolean challenge(String... books) {
		String searchedWord= books[books.length-1];
		int isFound=0;
		
	
		
		for (String bookname : books) {
			if(bookname==searchedWord)   // the word that we are searching for 
			{
				continue;
			}
			
			if(map.containsKey(bookname))
			{
				Dictionary d= map.get(bookname);
				if(d.challenge(searchedWord))
				{
					isFound++;
				}
			}
			else
			{
				Dictionary d= new Dictionary(bookname);
				map.put(bookname, d);
				if(d.challenge(searchedWord))
				{
					isFound++;
				}
				
			}
		}
			
			if(isFound>0)
			{
				return true;
			}
			return false;

		
	
	}
	
	
	
	
	
	
	
	
	public boolean query(String... books) {
		
		String searchedWord= books[books.length-1];
		int isFound=0;
		
	
		
		for (String bookname : books) {
			if(bookname==searchedWord)   // the word that we are searching for 
			{
				continue;
			}
			
			if(map.containsKey(bookname))
			{
				Dictionary d= map.get(bookname);
				if(d.query(searchedWord))
				{
					isFound++;
				}
			}
			else
			{
				Dictionary d= new Dictionary(bookname);
				map.put(bookname, d);
				if(d.query(searchedWord))
				{
					isFound++;
				}
				
			}
		}
			
			if(isFound>0)
			{
				return true;
			}
			return false;

	
	}
	
	
	
	
	
	public int getSize()
	{
		return map.size();
	}
	
	
	
	
	
	public static DictionaryManager get()
	{
		if(cm==null)
		{
			cm= new DictionaryManager();
		}
		return cm;
	}
	
	
	
	
	
	
	
}

