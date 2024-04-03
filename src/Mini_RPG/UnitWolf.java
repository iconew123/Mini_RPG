package Mini_RPG;

import java.util.Vector;

public class UnitWolf extends Unit {

	public UnitWolf() {
		super(5);
		setName("늑대");
	}

	@Override
	public void skill(Unit target) {
		int wAttack = (int) (this.getPower() * 0.66);
		String message = String.format("[%s] 의 스킬 공격으로 [모든 유닛] 에게 [%d]만큼의 피해를 줍니다.", this.getName(), wAttack);
		System.out.println(message);
		Vector<Player> players = UnitManager.getInstance().getPlayerList();
		for (int i = 0; i < players.size(); i++) {
			Player onePlayer = players.get(i);
			if (onePlayer.isDead())
				continue;
			onePlayer.setHp(wAttack * -1);
			System.out.printf("[%s] 의 공격으로 [%s] 에게 [%d]의 피해를 입혔습니다.\n", this.getName(), onePlayer.getName(), wAttack);
		}
		System.out.println();

	}

}
