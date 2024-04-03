package Mini_RPG;

import java.util.Vector;

public class StageBattle extends Stage {

	private final int NORMAL_ATTACK = 1;
	private final int USE_SKILL = 2;

	private UnitManager unitManager = UnitManager.getInstance();
	private Vector<Player> playerList;
	private Vector<Unit> monsterList;
	private int livePlayer;
	private int liveMonster;

	private boolean turn;

	@Override
	public void update() {
		System.out.println("======[BATTLE]======");
		turn = true;
		resetMonster();
		battleMonster();
	}

	private int inputNumber(String text) {
		System.out.print(text);
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("숫자만 입력 가능");
		}
		return number;
	}

	private void resetMonster() {
		playerList = unitManager.getPlayerList();
		unitManager.summonRandomMonster(3);
		monsterList = unitManager.getMonsterList();
		livePlayer = playerList.size();
		liveMonster = monsterList.size();
	}

	private void battleMonster() {
		while (livePlayer > 0 && liveMonster > 0) {
			showUnitList();
			if (turn) {
				attackPlayers();
			} else {
				attackMonsters();
			}
			deadCount();
			turn = !turn;
		}
		showUnitList();
		GameManager.nextStage = "LOBBY";
	}

	private void showUnitList() {
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).isDead()) {
				System.err.println("[사망한 유닛] " + playerList.get(i));
			} else
				System.out.println(playerList.get(i));
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monsterList.size(); i++) {
			if (monsterList.get(i).isDead())
				System.err.println("[사망한 유닛] " + monsterList.get(i));
			else
				System.out.println(monsterList.get(i));
		}
		System.out.println();
	}

	private void deadCount() {
		int pDead = 0;
		int mDead = 0;
		for (int i = 0; i < playerList.size(); i++)
			if (playerList.get(i).isDead())
				pDead++;
		for (int i = 0; i < monsterList.size(); i++)
			if (monsterList.get(i).isDead())
				mDead++;
		livePlayer = playerList.size() - pDead;
		liveMonster = monsterList.size() - mDead;

		if (livePlayer == 0) {
			System.err.println("모든 플레이어 사망");
			GameManager.isEnd = true;
		}
	}

	private void attackPlayers() {
		System.out.println("===[메뉴 선택]===");
		for (int i = 0; i < playerList.size(); i++) {
			deadCount();
			if (liveMonster == 0)
				break;

			Player player = playerList.get(i);
			int randomTarget = targetMonster();
			if (player.isDead())
				continue;
			else if (player.isSilence()) {
				System.err.printf("침묵상태이므로 [%s]는 이번턴 동안 행동을 할 수 없습니다.\n", player.getName());
				player.setIsSilence();
				continue;
			}

			System.out.printf("[%s] [1.일반공격] [2.스킬사용 (%d/%d)]  ", player.getName(), player.getTimes(),
					player.getMaxTimes());
			int sel = inputNumber(">> ");

			if (sel == NORMAL_ATTACK) {
				player.attack(monsterList.get(randomTarget));
			} else if (sel == USE_SKILL) {
				if (player.getTimes() == 0) {
					System.err.println("스킬의 횟수를 모두 사용했습니다.");
					i--;
					continue;
				}
				player.setTimesMinus();
				useSkillPlayer(player, monsterList.get(randomTarget));
			} else if (sel == -1) {
				break;
			} else {
				i--;
				continue;
			}

		}
	}

	private int targetMonster() {
		int ranTarget = -1;
		while (true) {
			ranTarget = random.nextInt(monsterList.size());

			if (!monsterList.get(ranTarget).isDead())
				break;
		}
		return ranTarget;
	}

	private void useSkillPlayer(Player player, Unit target) {
		player.skill(target);
	}

	private void attackMonsters() {
		for (int i = 0; i < monsterList.size(); i++) {
			deadCount();
			if (livePlayer == 0)
				break;

			Unit unit = monsterList.get(i);
			if (unit.isDead())
				continue;

			int randomTarget = targetPlayer();
			int randomAction = random.nextInt(10) < 8 ? NORMAL_ATTACK : USE_SKILL;

			if (randomAction == NORMAL_ATTACK)
				unit.attack(playerList.get(randomTarget));
			else if (randomAction == USE_SKILL) {
				if (unit.getTimes() == 0) {
					i--;
					continue;
				}
				unit.setTimesMinus();
				UseSkillMonster(unit, playerList.get(randomTarget));
			} else {
				i--;
				continue;
			}
		}
	}

	private int targetPlayer() {
		int ranTarget = -1;
		while (true) {
			ranTarget = random.nextInt(playerList.size());

			if (!playerList.get(ranTarget).isDead())
				break;
		}
		return ranTarget;
	}

	private void UseSkillMonster(Unit unit, Player target) {
		unit.skill(target);
	}

}
