package CLIENTallAboutGame;

import java.util.List;

public interface GameObserver {
	
	public void notify(List<GameEvents> events);
	
}
