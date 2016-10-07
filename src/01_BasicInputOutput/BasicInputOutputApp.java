import java.util.Scanner;

class BasicInputOutputApp {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What in your name? ");
		String name = scanner.next();
		scanner.close();
		System.out.println("Hello " + name + ", Welcome to Java");
	}
}
