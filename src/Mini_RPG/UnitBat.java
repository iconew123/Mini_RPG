package Mini_RPG;

public class UnitBat extends Unit {

	public UnitBat() {
		this.setName("박쥐");
	}

	@Override
	void skill(Unit target) {
		System.out.println("공격한 대상에게 [실명] 상태이상을 부여합니다.");

	}

}
