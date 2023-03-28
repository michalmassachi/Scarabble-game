package test;

import java.util.ArrayList;

//import test.Tile.Bag;
//import test.Tile;

public class Board {
	private static Board b=null;
	public Tile[][] mat= new Tile [15][15];
	public char[][]matScore = new char [15][15];
	private Board() {
		matScore[7][7]='y';
		matScore[1][1]=matScore[2][2]=matScore[3][3]=matScore[4][4]= matScore[1][13]=matScore[2][12]=matScore[3][11]=matScore[4][10]=
	    matScore[10][4]=matScore[11][3]=matScore[12][2]=matScore[13][1]=matScore[10][10]=matScore[11][11]=matScore[12][12]=matScore[13][13]='y';			
		matScore[0][0]=matScore[0][7]=matScore[0][14]= matScore[0][7]=matScore[7][14]=matScore[0][14]=matScore[14][7]=matScore[14][14]='r';
		matScore[0][3]=matScore[0][11]=matScore[2][6]= matScore[2][8]=matScore[3][0]=matScore[3][7]=matScore[3][14]=matScore[6][2]=
	    matScore[6][6]=matScore[6][8]=matScore[6][12]= matScore[7][3]=matScore[7][11]=matScore[8][2]=matScore[8][6]=matScore[8][8]=matScore[8][12]=
	    matScore[11][0]=matScore[11][7]=matScore[11][14]= matScore[12][6]=matScore[12][8]= matScore[14][3]=matScore[14][11]='w';
		matScore[1][5]=matScore[1][9]=matScore[5][1]= matScore[5][5]=matScore[5][9]= matScore[5][13]=matScore[9][1]=matScore[9][5]=matScore[9][9]= 
		matScore[9][13]=matScore[13][5]=matScore[13][9]='b';
	}
	
	public Tile[][] getTile()
	{
		Tile[][] newmat= new Tile [15][15];
		for(int i=0; i<15; i++)
		{
			for(int j=0; j<15; j++)
			{
				if(mat[i][j]!=null)
				{
					newmat[i][j]=mat[i][j];
				}
				else
				{
					newmat[i][j]=null;
				}
			}
		}
		return newmat;
	}
	

	
	
	public boolean boardLegal(Word w)
	{
		int flag=0;
	
		if(w.vertical)
		{
			int i=w.getRow();
			for(int h=0; h<w.tiles.length; h++)
			{
				if(i>14||i<0)
				{
					return false;
				}
				i++;
				
			}
			i=w.getRow();
			for(int h=0; h<w.tiles.length; h++)
			{
				int j=w.getCol();
				if(i==7 && j==7)
				{
					// means a star
					flag=1;
				}
				i++;
				
			}
			
			
			for(int h=0 ; h<w.tiles.length; h++)
			{
				if(w.tiles[h]==null)
				{
					flag=1; // means leaning on a letter חופף
				}
			}
			
			
		
			
			i=w.getRow();
			int p=0;
			for(int h=0 ; h<w.tiles.length; h++)
			{
				int j=w.getCol();
				if(mat[i][j]!=null)
				{
					if(w.tiles[h]!=null)
					{
							if(mat[i][j].letter==w.tiles[p].letter)
						{
							// means leaning on a letter חופף
							flag=1;
						}
					
					}
				}
				
				if(mat[i][j-1]!=null)
				{
					// means leaning on a letter
					flag=1;
				}
				if(mat[i][j+1]!=null)
				{
					// means leaning on a letter
					flag=1;
				}
				p++;
				i++;
				
			}
		}
			
			
		
				
		if(!w.vertical)
		{
			int i=w.getCol();
			for(int h=0; h<w.tiles.length; h++)
			{
				if(i>14||i<0)
				{
					return false;
				}
				i++;
			}
			i=w.getCol();
			for(int h=0; h<w.tiles.length; h++)
			{
			
				int j=w.getRow();
				if(i==7 && j==7)
				{
					// means a star
					flag=1;
				}
				i++;
			}
			
			for(int h=0 ; h<w.tiles.length; h++)
			{
				if(w.tiles[h]==null)
				{
					flag=1; // means leaning on a letter  חופף
				}
			}
			
			
			
			 i=w.getRow();
			 int j=w.getCol();
			 int p=0;
			for(int h=0; h<w.tiles.length; h++)
			{

				if(mat[i][j]!=null)
				{
					if(w.tiles[h]!=null)
					{
						if(mat[i][j].letter==w.tiles[p].letter)
						{
							// means leaning on a letter חופף
							flag=1;
						}
						

					}
				}
				
				if(mat[i-1][j]!=null)
				{
					// means leaning on a letter
					flag=1;
				}
				if(mat[i+1][j]!=null)
				{
					// means leaning on a letter
					flag=1;
				}
					
				
				p++;
				j++;
			}
					
			
		}
		
		
		if(flag==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	
	
	
	public boolean dictionaryLegal(Word w)
	{
		return true;
	}
	
	
	
	
	
	public ArrayList<Word> getWords(Word w)
	{
		 ArrayList<Word> a= new ArrayList<Word>();
		 int place=0;
		a.add(place, w);
		
		if(!w.vertical)
		{ 
			int i=w.getRow();
			int j=w.getCol();
			
				for(int h=0; h<w.tiles.length; h++)
				{
					int count1=0, count2=0;
					if(w.tiles[h]!=null&&mat[i][j]==null )
					{
							//if(w.getRow()>0 && w.getRow()<14)
							//{
							int z=w.getRow()-1;
							while(mat[z][j]!=null&& z>=0)
							{
								z--;
								count1++;
							}
							int n=w.getRow()+1;
							while(mat[n][j]!=null && n<=14)
							{
								n++;
								count2++;
							}
						//}
						/*if(w.getRow()==0)
						{
							int n=w.getRow();
							while(mat[n][j]!=null && n<=14)
							{
								n++;
								count1++;
							}
				        }
						if(w.getRow()==14)
						{
							int z=w.getRow();
							while(mat[z][j]!=null&& z>=0)
							{
								z--;
								count1++;
							}
						}*/
						
						if(count1!=0|| count2!=0)
						{
							Tile[] ts=new Tile[count1+count2+1];
							int newrow;
							z++;
							newrow=z;
							for(int m=0; m<count1; m++)
							{
		
								ts[m]=mat[z][j];
								z++;
														
							}
							ts[count1]=w.tiles[h];
							
							n= i+1;
							for(int m=0; m<count2; m++)
							{
		
								ts[count1+1+ m]=mat[n][j];
								
								n++;
														
							}
							Word newWord=new Word(ts,newrow,j,true);
							place++;
							a.add(place, newWord);
						}
					 }
					
					j++;
				}
			
			
			//checking in the sides of the word
			int k=w.getCol()-1;
			i=w.getRow();
			int count1=0, count2=0;
			while(mat[i][k]!=null)
			{
				k--;
				count1++;
			}
			int r=w.getCol()+w.tiles.length;
			while(mat[i][r]!=null)
			{
				r++;
				count2++;
			}
			if(count1!=0|| count2!=0)
			{	
			Tile[] ts=new Tile[count1+count2+w.tiles.length];
			int newcol;
			k++;
			newcol=k;
			for(int m=0; m<count1; m++)
			{

				ts[m]=mat[i][k];
				k++;
										
			}
			for(int p=0; p<w.tiles.length; p++)
			{
				if(w.tiles[p]==null)
				{
					ts[count1+p]=mat[i][w.getCol()+p];
				}
				else
				{
					ts[count1+p]=w.tiles[p];	
				}						
			}

			r=w.getCol()+w.tiles.length;
			for(int m=0; m<count2; m++)
			{
				ts[count1+w.tiles.length+ m]=mat[i][r];
				r++;
										
			}
		
			Word newWord=new Word(ts,i,newcol,false);
			place++;
			a.add(place, newWord);
		}
				
		}
		
		
		
		if(w.vertical)
		{ 
			int i=w.getRow();
			int j=w.getCol();
			for(int h=0; h<w.tiles.length; h++)
			{
					int count1=0, count2=0;
					if(w.tiles[h]!=null&&mat[i][j]==null )
					{
						int z=w.getCol()-1;
						while(mat[i][z]!=null&& z>=0)
						{
							z--;
							count1++;
						}
						int n=w.getCol()+1;
						while(mat[i][n]!=null&& n<=14)
						{
							n++;
							count2++;
						}
						
						if(count1!=0|| count2!=0)
						{
							Tile[] ts=new Tile[count1+count2+1];
							int newcol;
							z++;
							newcol=z;
							for(int m=0; m<count1; m++)
							{
		
								ts[m]=mat[z][j];
								z++;
														
							}
							ts[count1]=w.tiles[h];
							
							n=j+1;
							for(int m=0; m<count2; m++)
							{
		
								ts[count1+1+ m]=mat[i][n];
							
								n++;
														
							}
							Word newWord=new Word(ts,i,newcol,false);
							place++;
							a.add(place, newWord);
						}
						
					}
					i++;
			}
			
			//checking up and down of the word
			int k=w.getRow()-1;
			j=w.getCol();
			int count1=0, count2=0;
			while(mat[k][j]!=null)
			{
				k--;
				count1++;
			}
			int r=w.getRow()+w.tiles.length;
			while(mat[r][j]!=null)
			{
				r++;
				count2++;
			}
			if(count1!=0|| count2!=0)
			{
				Tile[] ts=new Tile[count1+count2+w.tiles.length];
				int newrow;
				k++;
				newrow=k;
				for(int m=0; m<count1; m++)
				{
	
					ts[m]=mat[k][j];
					k++;
											
				}
				for(int p=0; p<w.tiles.length; p++)
				{
					if(w.tiles[p]==null)
					{
						ts[count1+p]=mat[w.getRow()+p][j];
					}
					else
					{
						ts[count1+p]=w.tiles[p];	
					}								
				}
	
				r=w.getRow()+w.tiles.length;
				for(int m=0; m<count2; m++)
				{
					ts[count1+w.tiles.length+ m]=mat[i][r];
					r++;
											
				}
				Word newWord=new Word(ts,newrow,j,true);
				place++;
				a.add(place, newWord);
			}
		
		}
			
		return a;
	}
	
	
	
		
	
	int scoreTile(char c)
	{
		if(c=='A'|| c=='E' || c=='I' || c=='L' || c=='N' || c=='O' || c=='R' || c=='S'
				|| c=='T' || c=='U')
		{
			return 1;
		}
		if(c=='B'|| c=='C' || c=='M' || c=='P')
		{
			return 3;
		}		
		if(c=='D'|| c=='G')
		{
			return 2;
		}		
		if(c=='F'|| c=='H' || c=='V' || c=='W'|| c=='Y')
		{
			return 4;
		}	
		if(c=='K')
		{
			return 5;
		}
		if(c=='J'|| c=='X')
		{
			return 8;
		}
		if(c=='Q'|| c=='Z')
		{
			return 10;
		}
		return 0;
	}
	
	
	public int getScore(Word w, int IsFirstStar)
	{
		int score=0;
		for(int i=0; i< w.tiles.length; i++)
		{
			if(w.tiles[i]==null)
			{
				if(w.vertical)
				{
					score+= scoreTile(mat[w.getRow()+i][w.getCol()].letter);
				}
				if(!w.vertical)
				{
					score+= scoreTile(mat[w.getRow()][w.getCol()+i].letter);
				}
			}
			
			
			else
			{
			
				if(w.tiles[i].letter=='A'|| w.tiles[i].letter=='E' || w.tiles[i].letter=='I' || w.tiles[i].letter=='L' || w.tiles[i].letter=='N' || w.tiles[i].letter=='O' || w.tiles[i].letter=='R' || w.tiles[i].letter=='S'
						|| w.tiles[i].letter=='T' || w.tiles[i].letter=='U')
				{
					score++;
				}
				if(w.tiles[i].letter=='B'|| w.tiles[i].letter=='C' || w.tiles[i].letter=='M' || w.tiles[i].letter=='P')
				{
					score= score+3;
				}		
				if(w.tiles[i].letter=='D'|| w.tiles[i].letter=='G')
				{
					score= score+2;
				}		
				if(w.tiles[i].letter=='F'|| w.tiles[i].letter=='H' || w.tiles[i].letter=='V' || w.tiles[i].letter=='W'|| w.tiles[i].letter=='Y')
				{
					score= score+4;
				}	
				if(w.tiles[i].letter=='K')
				{
					score= score+5;
				}
				if(w.tiles[i].letter=='J'|| w.tiles[i].letter=='X')
				{
					score= score+8;
				}
				if(w.tiles[i].letter=='Q'|| w.tiles[i].letter=='Z')
				{
					score= score+10;
				}
			}
			}
			
			
			if(w.vertical)
			{
				int i=w.getRow();
				int p=0;
				for(int h=0; h<w.tiles.length; h++)
				{
					
					if(matScore[i][w.getCol()]=='w')//תכלת
					{
						int x=scoreTile(w.tiles[p].letter);
						score= score-x+ (x*2);
					}
						
					
					if(matScore[i][w.getCol()]=='b')
					{
						int x=scoreTile(w.tiles[p].letter);
						score= score-x+ (x*3);
					}
					p++;
					i++;
				}
				
				 i=w.getRow();
				 p=0;
				for(int h=0; h<w.tiles.length; h++)
				{
					//if(w.tiles[h]!=null)
					//{
					
						if(matScore[i][w.getCol()]=='y')
						{
							if(i==7 && w.getCol()==7)
							{
								if(IsFirstStar==0)
								{
									score= score*2;
								}
							}
							else
							{
								score= score*2;
							}

						}
						if(matScore[i][w.getCol()]=='r')
						{
							score= score*3;
						}
						
					//}
						p++;
						i++;
					
					}
			
			
				}
			
		
		
	
	
	if(!w.vertical)
	{ 
		int i=w.getCol();
		int p=0;
		
		for(int h=0; h<w.tiles.length; h++)
		{
			//if(w.tiles[h]!=null)
			//{
			if(matScore[w.getRow()][i]=='w')
			{
				int x=scoreTile(w.tiles[p].letter);
				score= score-x+ (x*2);
			}
			
			if(matScore[w.getRow()][i]=='b')
			{
				int x=scoreTile(w.tiles[p].letter);
				score= score-x+ (x*3);
			}
			
			p++;
			i++;
		}
		
		i=w.getCol();
		p=0;
			for(int h=0; h<w.tiles.length; h++)
			{	
				if(matScore[w.getRow()][i]=='r')
				{
					score= score*3;
				}
				if(matScore[w.getRow()][i]=='y')
				{
						if(i==7 && w.getCol()==7)
						{
							if(IsFirstStar==0)
							{
								score= score*2;
								
							}
						}
						else
						{
							score= score*2;
						}
				}
				p++;
				i++;
				
			}


			//}
				
			}
		
		
	
	
		return score;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int tryPlaceWord(Word w)
	{	
		int flag=0;
		int score=0;
		if(boardLegal(w))
		{
			 ArrayList<Word> a= getWords(w);
			 for(int i=0; i<a.size(); i++)
			 {
				 if(!dictionaryLegal(a.get(i)))
				 {
					 flag=1;
				 }
			 }
			 
			 int FirstStar;
			 if(mat[7][7]==null)
			 	{
			 		 FirstStar=0;// it is the first word on the star
			 	}
			 else
			 {
				 FirstStar=1;  // it isn't the first word on the star
			 }
			 
			 
			 if(flag==0)
			 {
				 for(int i=0; i<a.size(); i++)
				 {
					 if(a.get(i).vertical)
					 {
						
						 int j=(a.get(i).getRow());
						 for(int h=0; h<a.get(i).tiles.length; h++)
						 {	
						 	if(a.get(i).tiles[h]==null)
						 	{
						 	
						 		j++;
						 	}
						 	else
						 	{
							 mat[j][a.get(i).getCol()]=a.get(i).tiles[h];
							 j++;
						
						 	}
						 }
					 }
					 
					 if(!(a.get(i).vertical))
					 {
						 int j=(a.get(i).getCol());
						 for(int h=0; h<a.get(i).tiles.length; h++)
						 {	
							 if(a.get(i).tiles[h]==null)
						 	{
						 		
						 		j++;
						 	}
						 	else
						 	{
							 	mat[a.get(i).getRow()][j]=a.get(i).tiles[h];
							 	j++;
							 	
							 }
						 }
					 }
					  
				 }
				 
				 
				 for(int i=0; i<a.size(); i++)
				 {	
					 score+= getScore(a.get(i),FirstStar);
					 
				 }
				 
			 }
			 
			 
		}
		
		if(!boardLegal(w))
		{
			flag=1;
		}
		
		if(flag==0)
		{
			return score;
		}
		
		if(flag==1)
		 {
			 return 0;
		 }
		return 0;
	}
	
	
	
	
	
	
	
	
	public static Board getBoard()
	{
		if(b==null)
		{
			b= new Board();
		}
		return b;
	}
		

}
