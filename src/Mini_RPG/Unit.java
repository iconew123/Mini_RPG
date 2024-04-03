package Mini_RPG;

public abstract class Unit {

	private int maxHp;
	private int hp;
	private String name;
	private int power;
	private boolean isDead;
	private int times;

	public Unit(int hp, String name, int power, int times) {
		this.maxHp = hp;
		this.hp = hp;
		this.name = name;
		this.power = power;
		this.times = times;
	}

	public Unit(int times) {

	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp += hp;
		if (this.hp <= 0) {
			this.hp = 0;
			this.isDead = !this.isDead;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return this.power;
	}

	public boolean isDead() {
		return this.isDead;
	}

	public int getTimes() {
		return this.times;
	}

	public void setTimesMinus() {
		this.times--;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%s] : [%d/%d] , [%d]", this.name, this.hp, this.maxHp, this.power);
	}

	public void init(String name, int hp, int power) {
		this.maxHp = hp;
		this.hp = hp;
		this.name = name;
		this.power = power;
	}

	public void attack(Unit target) {
		String message = String.format("[%s] 의 일반 공격으로 [%s]에게 [%d]만큼의 피해를 입혔습니다.", this.name, target.name, this.power);
		System.out.println(message);
		target.setHp(this.power * (-1));
		if (target.getHp() == 0)
			System.out.printf("[%s] 유닛 사망\n", target.getName());
	}

	// 스킬에 사용 횟수 제한
	public abstract void skill(Unit target);
}
