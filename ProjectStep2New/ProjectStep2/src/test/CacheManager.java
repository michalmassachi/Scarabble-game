package test;

import java.util.HashSet;

public class CacheManager {
	int size=0;
	int maxSize;
	CacheReplacementPolicy CRP;
	HashSet<String> hs= new HashSet<>();
	public CacheManager(int maxSize, CacheReplacementPolicy CRP) {
		this.maxSize=maxSize;
		this.CRP= CRP;
	}

	Boolean query(String word)
	{
		if(hs.contains(word))
			return true;
		else
			return false;
	}
	
	void add(String word)
	{
		hs.add(word);
		size++;
		CRP.add(word);
		if(size>maxSize)
		{
			String s =CRP.remove();
			hs.remove(s);
			size--;
		}
	}
	
	
	
}
