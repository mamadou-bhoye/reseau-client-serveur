package CLIENTallAboutGame;

public class WallV3 extends NonTraversable{
	
	private static final int PV3 = 3;

	public WallV3(Coordinate coord, Terrain terrain) {
		super(coord, terrain);
	}

	@Override
	public TerrainElementType getType() {
		return TerrainElementType.WallV3;
	}
	

}
