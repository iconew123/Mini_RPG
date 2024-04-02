package Mini_RPG;

import java.util.HashMap;
import java.util.Map;

public class GameManager {

	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	private String curStage;
	private static String nextStage;

	public GameManager() {
		curStage = "";
	}

	private boolean isRun() {
		return nextStage.equals("END") ? false : true;
	}

	public void run() {
		while (isRun()) {

		}
	}
}
