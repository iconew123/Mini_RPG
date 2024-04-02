package Mini_RPG;

public class Player extends Unit {

	public Player(int hp, String name, int power) {
		super(hp, name, power);
	}

	@Override
	void skill(Unit target) {
		if (this.getName().equals("전사"))
			smash(target);
		else if (this.getName().equals("마법사"))
			wideAttack();
		else if (this.getName().equals("힐러"))
			heal();
	}

	private void smash(Unit target) {
		System.out.println("하나의 몬스터에게 강하게 내리칩니다.");
	}

	private void wideAttack() {
		System.out.println("모든 몬스터들에게 광역피해를 줍니다.");
	}

	private void heal() {
		System.out.println("파티원 모두를 일정부분 치유합니다.");
	}

}
