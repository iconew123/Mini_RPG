package Mini_RPG;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class GameManager {

	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	private Vector<Player> playerList;
	private Vector<Unit> monsterList;
	private String curStage;
	private static String nextStage;

	public GameManager() {
		setStage();
		setPlayerList();
		curStage = "";
		nextStage = "LOBBY";
	}

	private void setStage() {

	}

	private void setPlayerList() {

	}

	private boolean isRun() {
		return nextStage.equals("END") ? false : true;
	}

	public void run() {
		while (isRun()) {

		}
	}
}
