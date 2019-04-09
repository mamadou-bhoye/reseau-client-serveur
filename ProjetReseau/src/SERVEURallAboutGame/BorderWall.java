package SERVEURallAboutGame;

public class BorderWall extends NonTraversable{
	
	public BorderWall(Coordinate coord, Terrain terrain) {
		super(coord, terrain);
	}

	@Override
	public TerrainElementType getType() {
		return TerrainElementType.BorderWall;
	}

}
