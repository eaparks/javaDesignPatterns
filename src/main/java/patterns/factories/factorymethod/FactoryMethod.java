package patterns.factories.factorymethod;

public class FactoryMethod {

}

enum CoordinateSystem {
	CARTESIAN,
	POLAR
}

class Point {

	private double x;
	private double y;

	/*public*/ private  Point(double x, double y) {		// Make private to force factory method usage.
		this.x = x;
		this.y = y;
	}

	// for polar coords:
	// Can't do with same signature as above
//	public Point(double rho, double theta) {
//		x = ....;
//		y = ....;
//	}

	// Workaround to above scenario:
	/*public*/ private Point(double a, double  b, CoordinateSystem cs) {		// Needs javadoc to describe a, b. Ugly! Bad idea
		switch (cs) {
			case CARTESIAN:
				this.x = a;
				this.y = b;
				break;
			case POLAR:
				x = a * Math.cos(b);
				y = a * Math.sin(b);
				break;
		}
	}

	public static Point newCartesianPoint(double x, double y) {
		return new Point(x, y);
	}

	public static Point newPolarPoint(double rho, double theta) {

		return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
	}

}

class Demo {

	public static void main(String[] args) {
		Point point = Point.newPolarPoint(2, 3);
	}
}
