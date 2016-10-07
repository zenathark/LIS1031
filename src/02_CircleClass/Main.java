class Main {
	public static void main(String args[]) {
		if (args.length == 1) {
			Circle circle = new Circle(Double.parseDouble(args[0]));
			System.out.println("The area of the circle is: " + circle.getArea().toString());
			System.out.println("The perimeter of the circle is: " + circle.getPerimeter().toString());
			System.out.println("Bye");
		} else {
			System.out.println("Error invoking this application");
		}
	}
}
