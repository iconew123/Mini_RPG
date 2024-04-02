package Mini_RPG;

public class UnitWolf extends Unit {

	public UnitWolf() {
		setName("늑대");
	}

	@Override
	void skill(Unit target) {
		System.out.println("광역 공격을 합니다.");

	}

}
