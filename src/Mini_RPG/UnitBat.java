package Mini_RPG;

public class UnitBat extends Unit {

	public UnitBat() {
		super(5);
		setName("박쥐");
	}

	@Override
	public void skill(Unit target) {
		String message = String.format("[%s] 의 스킬사용으로 [%s] 에게 [침묵] 상태이상을 부여합니다.", this.getName(), target.getName());
		Player targetPlayer = (Player) target;
		targetPlayer.setIsSilence();
		System.out.println(message);
	}

}
