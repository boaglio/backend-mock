package mockapp;

public class Hits {

	private static long counter = 1;

	public static void add() {
		counter++;
	}

	public static long get() {
		return counter;
	}

}
