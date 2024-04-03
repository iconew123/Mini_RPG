package Mini_RPG;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	private Random random = new Random();

	private Vector<Player> playerList = new Vector<Player>();
	private Vector<Unit> monsterList = new Vector<Unit>();
	private String path = "Mini_RPG.";
	private String[] monsterKind = { "UnitBat", "UnitOrc", "UnitWolf" };

	private UnitManager() {
		playerList.add(new Player(0, "전사", 50));
		playerList.add(new Player(0, "마법사", 75));
		playerList.add(new Player(0, "힐러", 25));
	}

	private static UnitManager instance = new UnitManager();

	public static UnitManager getInstance() {
		return instance;
	}

	public Vector<Unit> getMonsterList() {
		return this.monsterList;
	}

	public Vector<Player> getPlayerList() {
		return this.playerList;
	}

	public void summonRandomMonster(int size) {
		monsterList.clear();
		for (int i = 0; i < size; i++) {
			int num = random.nextInt(monsterKind.length);
			try {
				Class<?> clazz = Class.forName(path + monsterKind[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit tmp = (Unit) obj;
				int hp = random.nextInt(100) + 200;
				int power = random.nextInt(10) + 20;
				tmp.init(tmp.getName(), hp, power);
				monsterList.add(tmp);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
