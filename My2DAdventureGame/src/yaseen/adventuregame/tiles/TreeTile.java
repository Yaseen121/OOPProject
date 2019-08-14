package yaseen.adventuregame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import yaseen.adventuregame.gfx.Assets;

public class TreeTile extends Tile
{

	public TreeTile(int id) 
	{
		super(Assets.tree, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

}
