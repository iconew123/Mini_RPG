package Mini_RPG;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
	// 싱글톤 패턴 바꾸끼
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	private String curStage;
	public static String nextStage;
	public static boolean isEnd;

	public GameManager() {
		setStage();
		curStage = "";
		nextStage = "TITLE";
	}

	private void setStage() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
	}

	private boolean isRun() {
		return nextStage.equals("END") || isEnd ? false : true;
	}

	private void changeStage() {
		Stage stage = stageList.get(nextStage);
		curStage = nextStage;
		System.out.println("현재 스테이지 : " + curStage);
		stage.update();
	}

	public void run() {
		while (isRun()) {
			changeStage();
		}
		System.out.println("게임종료");
	}
}
