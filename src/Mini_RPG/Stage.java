package Mini_RPG;

import java.util.Random;
import java.util.Scanner;

public abstract class Stage {

	public Random random = new Random();
	public Scanner scan = new Scanner(System.in);

	public abstract void update();
}
