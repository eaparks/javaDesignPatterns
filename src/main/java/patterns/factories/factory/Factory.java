package patterns.factories.factory;

public class Factory {
}

enum CoordinateSystem {
	CARTESIAN,
	POLAR
}

class Point {

	private double x;
	private double y;

	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	private Point(double a, double  b, CoordinateSystem cs) {
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

	public static class Factory {

		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}

		public static Point newPolarPoint(double rho, double theta) {

			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}
}



class Demo {

	public static void main(String[] args) {
		Point point = Point.Factory.newPolarPoint(2, 3);
//		Point point2 = new Point(4, 5);	// constructor is  private
	}
}

