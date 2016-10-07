/**
 * Represents a geometrical circle.
 * This class is a representation of an Euclidean geometrical circle. A circle
 * in Euclidean Geometry is described as a simple closed curve that divides
 * the plane in two regions: an internal region and an external region. Its
 * geometrical properties are described using the magnitude of its radius.
 * The radius is represented through the call propertie radius.
 *
 * @author Juan Carlos Galan Hernandez
 */
final class Circle {
	private Double radius;

	/**
	 * Creates a new circle with the given radius.
	 * Creates a new instance of the circle class using the given magnitude as
	 * the radius of the circle.
	 *
	 *  @param radius the radius of the new circle.
	 */
	public Circle(Double radius) {
		this.radius = radius;
	}

	/**
	 * Calculates the area of the circle. This method returns the area
	 * of this circle using the radius property and the equation defined
	 * by πr².
	 *
	 * @returns The area of the circle.
	 */
	public Double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	/**
	 * Calculates the perimeter of the circle. This method returns the perimeter
	 * of this circle using the radius property and the equation defined
	 * by 2πr.
	 *
	 * @returns The perimeter of the circle.
	 */
	public Double getPerimeter() {
		return 2 * radius * Math.PI;
	}
}
