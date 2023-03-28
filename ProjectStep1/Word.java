package test;

import java.util.Arrays;
//import test.Tile.Bag;
//import test.Tile;

public class Word {

	public Tile[] tiles;
	public int row;
	public int col;
	public boolean vertical;
	
	public Word(Tile[] t, int r, int c, boolean v) {
		tiles=t;
		row=r;
		col=c;
		vertical=v;
	}

	public Tile[] getTiles() {
		return tiles;
	}


	public int getRow() {
		return row;
	}


	public int getCol() {
		return col;
	}


	public boolean isVertical() {
		return vertical;
	}


	/*@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}*/
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return row == word.row && col == word.col && vertical == word.vertical && Arrays.equals(tiles, word.tiles);
    }
	
}