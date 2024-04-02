package Mini_RPG;

public class StageLobby extends Stage {

	private final int BATTLE = 1;
	private final int END = 2;

	private int inputNumber(String text) {
		System.out.print(text);
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("숫자만 입력가능");
		}
		return number;
	}

	@Override
	public void update() {
		System.out.println("======[LOBBY]======");
		System.out.println("[1].전투\t[2].종료");
		int choice = inputNumber(">> ");

		if (choice == BATTLE) {
			GameManager.nextStage = "BATTLE";
		} else if (choice == END)
			GameManager.nextStage = "END";

	}

}
