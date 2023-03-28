package test;

import java.util.Objects;
import java.util.Random;

public class Tile {

	public final char letter;
	public final int score;
	private Tile(char letter, int score)
	{
		this.letter= letter;
		this.score= score;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		return letter == other.letter && score == other.score;
	}


	@Override
	public int hashCode() {
		return Objects.hash(letter, score);
	}
	
	
	
	public static class Bag {
		private static Bag b=null;
		int NumTiles;
		public int[] intArrayNum = new int[26]; //represents the amount by the rules
		public int[] intArray = new int[26];    // represents the current amount
		public Tile[] tileArray= new Tile[26];
		private Bag() {
			NumTiles=98;
			intArrayNum = new int[]{ 9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1 }; 
			intArray = new int[]{ 9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1 }; 
			tileArray= new Tile[] {new Tile('A',1),
												new Tile('B',3),
												new Tile('C',3),
												new Tile('D',2),
												new Tile('E',1),
												new Tile('F',4),
												new Tile('G',2),
												new Tile('H',4),
												new Tile('I',1),
												new Tile('J',8),
												new Tile('K',5),
												new Tile('L',1),
												new Tile('M',3),
												new Tile('N',1),
												new Tile('O',1),
												new Tile('P',3),
												new Tile('Q',10),
												new Tile('R',1),
												new Tile('S',1),
												new Tile('T',1),
												new Tile('U',1),
												new Tile('V',4),
												new Tile('W',4),
												new Tile('X',8),
												new Tile('Y',4),
												new Tile('Z',10)};	
			
		}
		
		
		public Tile  getRand()
		{
			if(NumTiles==0)
			{
				return null;
			}
				
			Random r= new Random();
			
			int x=r.nextInt(26);
			
			while(intArray[x]==0)
			{
				x=r.nextInt(26);
			}
			
			intArray[x]--;
			NumTiles--;
	
			Tile t=tileArray[x];
		
			return t;
		} 
		
		
		public Tile  getTile(char c)
		{
			for(int i=0; i<26;i++)
			{
				if(tileArray[i].letter==c)
				{
					if(intArray[i]!=0)
					{
						intArray[i]--;
						NumTiles--;
						return tileArray[i];
					}
				}
				/*else
				{
					return null;
				}*/
			}
			return null;
		}
		
		
		
		public void put(Tile t)
		{
			for(int i=0; i<26;i++)
			{
				if(tileArray[i].letter==t.letter)
				{
					if(intArray[i]<intArrayNum[i])
					{
						intArray[i]++;
						NumTiles++;
					}
				}
					
			}
		}
		
		
		
		
		
		public int size()
		{
			return NumTiles;
		}
		
		
		
	public int[] getQuantities()
	{
		 int[] intArraynew = new int[26];
		 for(int i=0; i<26; i++)
		 {
			 intArraynew[i]=intArray[i];
		 }
		 
		 return intArraynew;
	}
		
		
		
	public static Bag getBag()
	{
		if(b==null)
		{
			b= new Bag();
		}
		return b;
	}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}