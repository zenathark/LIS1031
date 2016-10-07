import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

class Cat {
	public static void main(String[] args) {
		if (args.length < 1 || args.length > 1) {
			System.out.println("Error, se esperaba un solo argumento.");
			return;
		}
		File f = new File(args[0]);
		try {
			FileInputStream fs = new FileInputStream(f);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}

	}
}
