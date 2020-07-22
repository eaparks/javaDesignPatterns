package patterns.prototype.codingexercise;

public class PrototypeExercise {

  // Implement Line.deepCopy() to perform a deep copy of the current Line object.
}

class Point {
  public int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Line {
  public Point start;
  public Point end;

  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public Line deepCopy() {
    Point startCopy = new Point(start.x, start.y);
    Point endCopy = new Point(end.x, end.y);
    return new Line(startCopy, endCopy);
  }
}
