package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;


public class IOSearcher {

	 static Boolean search(String word, String file1, String file2) //throws FileNotFoundException
	 {
	
		 Scanner myScaner1;
		try {
			myScaner1 = new Scanner(new BufferedReader(new FileReader(file1)));
			 while(myScaner1.hasNext())
			 {
				 String s= myScaner1.next();
				 if(s.equals(word))
				 {
					 return true;
				 }
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
				 if(s.equals(word))
				 {
					 return true;
				 }
			 }
			 myScaner2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return false;
	
}
}
