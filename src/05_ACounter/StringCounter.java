/**
 * This class is a wrapper of a String.
 * This class contains only one public method that
 * finds the amount of `a` characters on an
 * infinite string.
 *
 * @author Juan Carlos Galan Hernandez
 * @date 2016-09-22
 */

class StringCounter {
	//String Holder
	private String s;

	/**
	 * Default constructor.
	 * Creates an instance using the string "aaa" as default value.
	 */
	public StringCounter() {
		this("aaa");
	}

	/**
	 * This constructor creates a new instance with the given string.
	 *
	 * @argument s String for future calculations.
	 * @see StringCounter.solve
	 */
	public StringCounter(String s) {
		this.s = s;
	}

	/**
	 * Returns the amount of `a` character found on the given string.
	 *
	 * @argument s String that will be search.
	 * @return The amount of `a` inside s.
	 */
	private Integer countAs(String s) {
		Integer acc = 0;
		for(Integer c = 0; c < s.length(); c++)
			if (s.charAt(c) == 'a') acc++;
		return acc;
	}

	/**
	 * Returns the amount of `a` character on the instance String assuming that
	 * the String is infinite.
	 *
	 *
	 */
	public Integer solve(Integer n) {
		Integer k1 = countAs(this.s);
		// double j2 = Math.floor(n / this.s.length());
		// Double j3 = Double.valueOf(j2);
		Integer j2 = (Double.valueOf(Math.floor(n / this.s.length()))).intValue();
		String s2 = s.substring(0, n % this.s.length());
		Integer k2 = countAs(s2);
		Integer ans = j2 * k1 + k2;
		return ans;
	}
}
