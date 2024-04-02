package Mini_RPG;

public class UnitOrc extends Unit {

	public UnitOrc() {
		setName("오크");
	}

	@Override
	void skill(Unit target) {
		System.out.println("공격이 확정 크리티컬이 됩니다.");

	}

}
