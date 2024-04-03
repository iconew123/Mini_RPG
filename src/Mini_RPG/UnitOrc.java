package Mini_RPG;

public class UnitOrc extends Unit {

	public UnitOrc() {
		super(5);
		setName("오크");
	}

	@Override
	public void skill(Unit target) {
		int crit = this.getPower() * 2;
		String message = String.format("[%s]의 [치명타 공격]으로 [%s] 에게 [%d]의 피해를 입혔습니다.", this.getName(), target.getName(),
				crit);
		Player targetPlayer = (Player) target;
		targetPlayer.setHp(crit * -1);
		System.out.println(message);

	}

}
