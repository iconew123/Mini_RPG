package Mini_RPG;

import java.util.Vector;

public class Player extends Unit {

	private boolean isSilence;

	public Player(int hp, String name, int power) {
		super(hp, name, power, 10);
	}

	public boolean isSilence() {
		return this.isSilence;
	}

	public void setIsSilence() {
		this.isSilence = !this.isSilence;
	}

	@Override
	public void skill(Unit target) {
		if (this.getName().equals("전사"))
			smash(target);
		else if (this.getName().equals("마법사"))
			wideAttack();
		else if (this.getName().equals("힐러"))
			heal();
	}

	private void smash(Unit target) {
		String message = String.format("[%s] 의 스킬 공격으로 [%s]에게 [%d]만큼의 피해를 입혔습니다.", this.getName(), target.getName(),
				this.getPower() * 2);
		System.out.println(message);
		target.setHp(this.getPower() * -2);
	}

	private void wideAttack() {
		int wAttack = (int) (this.getPower() * 0.66);
		String message = String.format("[%s] 의 스킬 공격으로 [모든 유닛] 에게 [%d]만큼의 피해를 줍니다.", this.getName(), wAttack);
		System.out.println(message);
		Vector<Unit> monsters = UnitManager.getInstance().getMonsterList();
		for (int i = 0; i < monsters.size(); i++) {
			Unit oneMonster = monsters.get(i);
			if (oneMonster.isDead())
				continue;
			oneMonster.setHp(wAttack * -1);
			System.out.printf("[%s] 의 공격으로 [%s] 에게 [%d]의 피해를 입혔습니다.\n", this.getName(), oneMonster.getName(), wAttack);
		}
		System.out.println();
	}

	private void heal() {
		String message = String.format("[%s] 의 스킬로 [모든 유닛] 에게 [%d]만큼의 체력을 회복합니다.", this.getName(), this.getPower());
		System.out.println(message);
		Vector<Player> players = UnitManager.getInstance().getPlayerList();
		for (int i = 0; i < players.size(); i++) {
			Player onePlayer = players.get(i);
			if (onePlayer.isDead())
				continue;

			int heal = this.getPower();
			if (onePlayer.getHp() + this.getPower() >= onePlayer.getMaxHp())
				heal = onePlayer.getMaxHp() - onePlayer.getHp();
			onePlayer.setHp(heal);
			System.out.printf("[%s] 의 힐로 [%s] 에게 [%d]의 체력을 회복합니다.\n", this.getName(), onePlayer.getName(), heal);
		}
	}

}
