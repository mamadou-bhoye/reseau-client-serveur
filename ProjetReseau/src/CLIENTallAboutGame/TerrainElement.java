package CLIENTallAboutGame;


public abstract class TerrainElement {
	protected Coordinate coord;
	protected Terrain terrain;
	
	public TerrainElement(Coordinate coord, Terrain terrain) {
		this.coord = coord;
		this.terrain = terrain;
	}
	
	
	public Coordinate getCoord() {
		return this.coord;
	}

	
	
	//Implement in each WaLL
	public abstract TerrainElementType getType();

	
}
