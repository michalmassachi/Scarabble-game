package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Dictionary {
	
	CacheReplacementPolicy lru=new LRU();
	CacheReplacementPolicy lfu=new LFU();
	CacheManager clru;
	CacheManager clfu;
	BloomFilter bf;
	String file1;
	String file2;
	
	
	public Dictionary(String file1,String file2) //throws NoSuchAlgorithmException, FileNotFoundException 
	{	this.file1= file1;
		this.file2= file2;
		
		CacheReplacementPolicy lru=new LRU();
		CacheReplacementPolicy lfu=new LFU();
        clru= new CacheManager(400, lru);
	    clfu= new CacheManager(100, lfu);
	    bf =new BloomFilter(256,"MD5","SHA1");
		
		Scanner myScaner1;
		try {
			myScaner1 = new Scanner(new BufferedReader(new FileReader(file1)));
			 while(myScaner1.hasNext())
			 {
				 String s= myScaner1.next();
				 bf.add(s);
			 }
			 myScaner1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		 Scanner myScaner2;
		try {
			myScaner2 = new Scanner(new BufferedReader(new FileReader(file2)));
			 while(myScaner2.hasNext())
			 {
				 String s= myScaner2.next();
				 bf.add(s);
			 }
			 myScaner2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
}
	
	
	Boolean query(String word) {
		try {
		if(clru.query(word))
		{
			return true;
		}
		else if(clfu.query(word))
		{
		  return false;
			
		}
		else
		{
			if(bf.contains(word))
			{
				clru.add(word);
				return true;
			}
			if(!bf.contains(word))
			{
				clfu.add(word);
				return false;
			}
			
		}
		
		}catch(Exception e) {
			System.out.println("there is an exception");
		}
		return null;
			
	}
	
	
	Boolean challenge(String word) //throws FileNotFoundException
	{
		try {
			if(IOSearcher.search(word, file1, file2))
			{
				clru.add(word);
				return true;
			}
			else
			{
				clfu.add(word);
				return false;
			}
		} catch(Exception e) {
			System.out.println("there is an exception");
			return false;
		}

	}
	
	
}
