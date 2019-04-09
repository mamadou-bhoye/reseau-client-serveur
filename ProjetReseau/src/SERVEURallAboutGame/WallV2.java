package SERVEURallAboutGame;

public class WallV2 extends NonTraversable{
	
	private static final int PV2 = 2;

	
	public WallV2(Coordinate coord, Terrain terrain) {
		super(coord, terrain);
	}

	@Override
	public TerrainElementType getType() {
		return TerrainElementType.WallV2;
	}

}
