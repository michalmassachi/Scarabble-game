package test;
import java.util.*;



public class LFU implements CacheReplacementPolicy {
	
	LinkedHashMap<String, Integer> hm= new 	LinkedHashMap<String, Integer>();
	LinkedList<String> ll = new LinkedList<> ();

	
	
	@Override
	public void add(String word) {
		if(hm.containsKey(word))
		{
			//@SuppressWarnings("unused")
			Integer v=hm.get(word);
			v++;
			hm.put(word, v);
		}
		else
		{
			hm.put(word, 1);
		}
		ll.add(word);

	}

	
	@Override
	public String remove() {
		Integer min = Collections.min(hm.values());
		Iterator<String> it=ll.iterator();
		while(it.hasNext())
		{
			@SuppressWarnings("unlikely-arg-type")
			String wantwdWord= it.next();
			Integer num=hm.get(wantwdWord);
			if(num==min)
			{
				hm.remove(wantwdWord);
				return wantwdWord;
			}
			//it.next();
			
		}
		return null;
	}
		
}
