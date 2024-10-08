package Uebungsblatt1;

import java.util.Arrays;

import java.text.DecimalFormat;

class Point {

    public double xPoint;
    public double yPoint;
    public Point(double xPoint, double yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }
    public double x() {
        return this.xPoint;
    }
    public double y() {
        return this.yPoint;
    }
    public String toString() {
        return "Point [x=" + x() + ", y=" + y() + "]";
    }
    public double distance(final Point p) {
        return Math.sqrt((x() - p.x()) * (x() - p.x()) + (y() - p.y()) * (y() - p.y()) );
    }

    public Point moved(double dx, double dy) {


        return new Point(this.xPoint + dx, this.yPoint + dy);

    }
}


class Triangle {

    public Point p0, p1, p2;

    public Triangle(Point a, Point b, Point c) {
        this.p0 = a;
        this.p1 = b;
        this.p2 = c;
    }
    public Point p0() {
        return p0;
    }

    public Point p1() {
        return p1;
    }

    public Point p2() {
        return p2;
    }
    public double perimeter() {
        return p0.distance(p1) + p1.distance(p2) + p2.distance(p0);
    }
    public double area() {
        double s = perimeter()/2;
        double seite1 = p0.distance(p1);
        double seite2 = p1.distance(p2);
        double seite3 = p2.distance(p0);
        return Math.sqrt(s*(s - seite1) * (s - seite2) * (s - seite3));
    }
    public Point lowerLeft() {
        return new Point(Math.min(p0.x(), Math.min(p1.x(), p2.x())), Math.min(p0.y(), Math.min(p1.y(), p2.y())));
    }
    public Point upperRight() {

        return new Point(Math.max(p0.x(), Math.max(p1.x(), p2.x())), Math.max(p0.y(), Math.max(p1.y(), p2.y())));

    }
    public Triangle moved(double dx, double dy) {

        double newXPoint0 = p0.xPoint + dx;
        double newXPoint1 = p1.xPoint + dx;
        double newXPoint2 = p2.xPoint + dx;

        double newYPoint0 = p0.yPoint + dy;
        double newYPoint1 = p1.yPoint + dy;
        double newYPoint2 = p2.yPoint + dy;

        Point p0 = new Point(newXPoint0, newYPoint0);
        Point p1 = new Point(newXPoint1, newYPoint1);
        Point p2 = new Point(newXPoint2, newYPoint2);

        return new Triangle(p0, p1, p2);

    }
    public Triangle zoomed(Point center, double factor) {
        var p1Origin = p0.moved(-center.x(), -center.y());
        var p2Origin = p1.moved(-center.x(), -center.y());
        var p3Origin = p2.moved(-center.x(), -center.y());

        var p1Zoomed = new Point(p1Origin.x() * factor, p1Origin.y() * factor);
        var p2Zoomed = new Point(p2Origin.x() * factor, p2Origin.y() * factor);
        var p3Zoomed = new Point(p3Origin.x() * factor, p3Origin.y() * factor);

        var p1Translated = p1Zoomed.moved(center.x(), center.y());
        var p2Translated = p2Zoomed.moved(center.x(), center.y());
        var p3Translated = p3Zoomed.moved(center.x(), center.y());

        return new Triangle(p1Translated, p2Translated, p3Translated);
    }
    public Triangle zoomed(double factor) {
        return zoomed(new Point(0, 0), factor);
    }
    public String toString() {
        return "Triangle [p0=" + p0() + ", p1=" + p1() + ", p2=" + p2() + "]";
    }
}

class TriangleTest {

    public static void withinTol(double a, double b) {
        System.out.println(Math.abs(a - b) < 1 ? "korrekt" : "falsch");
    }

    public static void testTheTriangleClass() {
        // Erzeuge Dreieck [-10,0], [0,24], [45,100]
        var t1 = new Triangle(new Point(-10, 0), new Point(0, 24), new Point(45, 100));
        System.out.println("t1: " + t1);

        System.out.print("Umfang für t1: ");
        System.out.println(t1.perimeter());

        System.out.print("Fläche für t1: ");
        System.out.println(t1.area());

        System.out.println("Strecken um den Punkt [0,1]  mit Faktor -1:");
        var t2 = t1.zoomed(new Point(0, 1), -1);
        System.out.println(t2);

        System.out.println("Verschiebe um dx 0 und dy -1:");
        System.out.println(t2.moved(0, -1));


    } // end class TriangleTest

    public static void main(String[] args) {
        testTheTriangleClass();

    }
}