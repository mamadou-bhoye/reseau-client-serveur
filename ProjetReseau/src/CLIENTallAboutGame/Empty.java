package CLIENTallAboutGame;

public class Empty extends Traversable{

	
	public Empty(Coordinate coord, Terrain terrain) {
		super(coord, terrain);
	}

	@Override
	public TerrainElementType getType() {
		return TerrainElementType.Empty;
	}

	
}
