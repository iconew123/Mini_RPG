package Mini_RPG;

public class StageTitle extends Stage {

	@Override
	public void update() {

		System.out.println("====== TEXT RPG ======");
		System.out.println("계속 하려면 [시작]을 입력하세요");
		String start = scan.next();

		if (start.equals("시작"))
			GameManager.nextStage = "LOBBY";

	}

}
