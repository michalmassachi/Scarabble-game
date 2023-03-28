package test;

import java.util.*;

@SuppressWarnings("unused")
public class LRU implements CacheReplacementPolicy{
	Queue<String> str_queue = new LinkedList<> ();
	
	
	@Override
	public void add(String word) {
		if(str_queue.contains(word))
		{
			str_queue.remove(word);
			str_queue.add(word);
		}
		
		else {	
		str_queue.add(word);
		}
		
	}
	
	
	

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String remove() {
		Iterator<String> it=str_queue.iterator();
		 String WantedWord=str_queue.peek();
		 
		 str_queue.remove(0);
		
		return WantedWord;
	}

}
