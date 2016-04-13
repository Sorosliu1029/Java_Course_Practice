package week7;

/**
 * Created by liuyang on 16/4/13.
 */
abstract class CommonShape implements ComparableShape {
    abstract public String print();

    abstract public double area();

    public int compare(ComparableShape a) {
        double abs_compare = Math.abs(area() - a.area());
        if (abs_compare <= 1e4) {
            return 0;
        } else {
            if (area() > a.area()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}

class Rectangle extends CommonShape {
    double hor;
    double ver;

    Rectangle(double horizontal, double vertical) {
        assert horizontal > 0;
        assert vertical > 0;
        hor = horizontal;
        ver = vertical;
    }

    public String print() {
        return "Shape: Rectangle, Horizontal_length: " + this.hor + ", Vertical_length: " + this.ver + ", Area: " + this.area() ;
    }

    public double area() {
        return this.hor * this.ver;
    }
}

class Square extends Rectangle {
    Square(double line) {
        super(line, line);
    }

    public String print() {
        return "Shape: Square, Line_length: " + this.hor + ", Area: " + this.area();
    }
}

class Fan extends CommonShape {
    double rad;
    double ang;

    Fan(double radius, double angle) {
        assert angle >= 0 && angle <= 360;
        assert radius > 0;
        rad = radius;
        ang = angle;
    }

    public String print() {
        return "Shape: Fan, Radius: " + this.rad + ", Angle: " + this.ang + ", Area: " + this.area();
    }

    public double area() {
        return this.rad * this.rad * Math.PI * (this.ang / 360.0);
    }
}

class Circle extends Fan {
    Circle(double radius) {
        super(radius, 360);
    }

    public String print() {
        return "Shape: Circle, Radius: " + this.rad + ", Area: " + this.area();
    }
}