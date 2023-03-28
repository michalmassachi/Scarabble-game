package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

public class BookScrabbleHandler  implements ClientHandler{
	
	BookScrabbleHandler(){}
	PrintWriter out;
	Scanner myScaner;
	BufferedReader in;
	

	@Override
	public void handleClient(InputStream inFromclient, OutputStream outToClient)  {

		try {
			in= new BufferedReader(new InputStreamReader(inFromclient));
			out= new PrintWriter(outToClient, true);
			String line;
			line= in.readLine();
		
		myScaner=new Scanner(line);
		myScaner.useDelimiter(",");
		String s=myScaner.next();
		
		
		String SentToDM1=myScaner.next();
		String SentToDM2=myScaner.next();
		String SentToDM3=myScaner.next();

		
		DictionaryManager dm=DictionaryManager.get();
		
		
		if(s.equals("Q"))
		{
			
			if(dm.query(SentToDM1,SentToDM2,SentToDM3 ))
			{
				out.println("true");

			}
			else
			{
				out.println("false");
			}

			
		}
			
			
			
		
		if(s.equals("C"))
		{
			if(dm.challenge(SentToDM1,SentToDM2,SentToDM3))
			{
				out.println("true");

			}
			else
			{
				out.println("false");
			}

	}
		
		
		
		
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	
		}
	
	

	@Override
	public void close() {

		try {
			in.close();
			myScaner.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
