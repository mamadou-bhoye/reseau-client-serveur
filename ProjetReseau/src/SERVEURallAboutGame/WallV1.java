package SERVEURallAboutGame;

public class WallV1 extends NonTraversable {
	
	private static final int PV1 = 1;

	
	public WallV1(Coordinate coord, Terrain terrain) {
		super(coord, terrain);
	}

	@Override
	public TerrainElementType getType() {
		return TerrainElementType.WallV1;
	}

}
