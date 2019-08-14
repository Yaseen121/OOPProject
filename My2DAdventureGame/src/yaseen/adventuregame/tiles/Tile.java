package yaseen.adventuregame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile 
{
	///Creating all the tiles using polymorphism and putting them in the tiles Tile array
	//So that when loading the world we can use the ids to load the tiles
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile treeTile = new TreeTile(1);
	public static Tile tallGrassTile = new TallGrassTile(2);
	public static Tile smallRockTile = new SmallRockTile(3);
	public static Tile crackedRockTile = new CrackedRockTile(4);
	public static Tile wellTile = new WellTile(5);
	
	public static Tile waterTile = new WaterTile(7);
	public static Tile waterUpperLeftTile = new WaterUpperLeftTile(8);
	public static Tile waterUpperMiddleTile = new WaterUpperMiddleTile(9);
	public static Tile waterUpperRightTile = new WaterUpperRightTile(10);
	public static Tile waterLeftTile = new WaterLeftTile(11);
	public static Tile waterRightTile = new WaterRightTile(12);
	public static Tile waterLowerLeftTile = new WaterLowerLeftTile(13);
	public static Tile waterLowerMiddleTile = new WaterLowerMiddleTile(14);
	public static Tile waterLowerRightTile = new WaterLowerRightTile(15);
	public static Tile waterInnerUpperLeftTile = new WaterInnerUpperLeftTile(16);
	public static Tile waterInnerUpperRightTile = new WaterInnerUpperRightTile(17);
	public static Tile waterInnerLowerLeftTile = new WaterInnerLowerLeftTile(18);
	public static Tile waterInnerLowerRightTile = new WaterInnerLowerRightTile(19);
	public static Tile cliffBendRightTile = new CliffBendRightTile(20);
	public static Tile cliffBendLeftTile = new CliffBendLeftTile(21);
	public static Tile cliffUpperLeftTile = new CliffUpperLeftTile(22);
	public static Tile cliffUpperMiddleTile = new CliffUpperMiddleTile(23);
	public static Tile cliffUpperRightTile = new CliffUpperRightTile(24);
	public static Tile cliffLeftTile = new CliffLeftTile(25);
	public static Tile cliffTile = new CliffTile(26);
	public static Tile cliffRightTile = new CliffRightTile(27);
	public static Tile cliffLowerLeftTile = new CliffLowerLeftTile(28);
	public static Tile cliffLowerMiddleTile = new CliffLowerMiddleTile(29);
	public static Tile cliffLowerRightTile = new CliffLowerRightTile(30);
	public static Tile stairsForwardLeftTile = new StairsForwardLeftTile(31);
	public static Tile stairsForwardRightTile = new StairsForwardRightTile(32);
	public static Tile stairsSideLeftTile = new StairsSideLeftTile(33);
	public static Tile stairsSideRightTile = new StairsSideRightTile(34);
	
	public static Tile bridgeSideLeftTile = new BridgeSideLeftTile(35);
	public static Tile bridgeSideRightTile = new BridgeSideRightTile(36);
	public static Tile bridgeForwardLeftTile = new BridgeForwardLeftTile(37);
	public static Tile bridgeForwardRightTile = new BridgeForwardRightTile(38);
	public static Tile bridgeCenterUpperLeftTile = new BridgeCenterUpperLeftTile(39);
	public static Tile bridgeCenterUpperRightTile = new BridgeCenterUpperRightTile(40);
	public static Tile bridgeCenterLowerLeftTile = new BridgeCenterLowerLeftTile(41);
	public static Tile bridgeCenterLowerRightTile = new BridgeCenterLowerRightTile(42);
	public static Tile sand = new Sand(43);
	public static Tile sandGrassBottom = new SandGrassBottom(44);
	public static Tile sandGrassRightSide = new SandGrassRightSide(45);
	public static Tile sandGrassRightBottomCorner = new SandGrassRightBottomCorner(46);
	//Constants
	public static final int TILEWIDTH = 32;
	public static final int TILEHEIGHT = 32;
	//Instance variables 
	protected BufferedImage texture;
	protected final int id;
	
	//Constructor 
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	//Draws tile to screen given its x and y position
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	//Method to return if block is solid (method is overwritten for tiles of types that are solid)
	public boolean isSolidBlock()
	{
		return false;
	}
	
	//Getters
	public int getId()
	{
		return id;
	}
}
