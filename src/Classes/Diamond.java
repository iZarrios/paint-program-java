package Classes;

import Classes.Shape;
import java.awt.Color;
import java.awt.Graphics;

public class Diamond extends Shape {

    private int x1, y1;
    private int x2, y2;
    private boolean fillColor = false;

    public boolean isFillColor() {
        return fillColor;
    }

    public void settFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    public Diamond(int x1, int y1, int x2, int y2, Color color, boolean nextfillColor) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fillColor = nextfillColor;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

//    @Override
        @Override
        public void draw(Graphics graph, Shape x) {
            Diamond r = (Diamond) x;
        graph.setColor(r.getColor());
        if (x.isFillColor()) {
            if (r.getX1() < r.getX2() && r.getY1() < r.getY2()) {//case A
                int[] a = {x1, x1 + (x2 - x1) / 2, x2, x1 + (x2 - x1) / 2};
                int[] b = {y1 + (y2 - y1) / 2, y1, y1 + (y2 - y1) / 2, y2};
                graph.fillPolygon(a, b, 4);
            } else if (r.getX1() > r.getX2() && r.getY1() > r.getY2()) {//case B
                int[] a = {x2, x2 + (x1 - x2) / 2, x1, x2 + (x1 - x2) / 2};
                int[] b = {y2 + (y1 - y2) / 2, y2, y2 + (y1 - y2) / 2, y1};
                graph.fillPolygon(a, b, 4);
            } else if (r.getX1() > r.getX2() && r.getY1() < r.getY2()) {//case C
                int[] a = {x2, x2 + (x1 - x2) / 2, x1, x2 + (x1 - x2) / 2};
                int[] b = {y1 + (y2 - y1) / 2, y1, y1 + (y2 - y1) / 2, y2};
                graph.fillPolygon(a, b, 4);
            } else if (r.getX1() < r.getX2() && r.getY1() > r.getY2()) {//case D
                int[] a = {x1, x1 + (x2 - x1) / 2, x2, x1 + (x2 - x1) / 2};
                int[] b = {y2 + (y1 - y2) / 2, y2, y2 + (y1 - y2) / 2, y1};
                graph.fillPolygon(a, b, 4);
            }
        } else {
            if (r.getX1() < r.getX2() && r.getY1() < r.getY2()) {//case A
                int[] a = {x1, x1 + (x2 - x1) / 2, x2, x1 + (x2 - x1) / 2};
                int[] b = {y1 + (y2 - y1) / 2, y1, y1 + (y2 - y1) / 2, y2};
                graph.drawPolygon(a, b, 4);
            } else if (r.getX1() > r.getX2() && r.getY1() > r.getY2()) {//case B
                int[] a = {x2, x2 + (x1 - x2) / 2, x1, x2 + (x1 - x2) / 2};
                int[] b = {y2 + (y1 - y2) / 2, y2, y2 + (y1 - y2) / 2, y1};
                graph.drawPolygon(a, b, 4);
            } else if (r.getX1() > r.getX2() && r.getY1() < r.getY2()) {//case C
                int[] a = {x2, x2 + (x1 - x2) / 2, x1, x2 + (x1 - x2) / 2};
                int[] b = {y1 + (y2 - y1) / 2, y1, y1 + (y2 - y1) / 2, y2};
                graph.drawPolygon(a, b, 4);
            } else if (r.getX1() < r.getX2() && r.getY1() > r.getY2()) {//case D
                int[] a = {x1, x1 + (x2 - x1) / 2, x2, x1 + (x2 - x1) / 2};
                int[] b = {y2 + (y1 - y2) / 2, y2, y2 + (y1 - y2) / 2, y1};
                graph.drawPolygon(a, b, 4);
            }
        }
    }

    @Override
    public boolean contains(int x, int y) {
        java.awt.Rectangle r = new java.awt.Rectangle();
        if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) {
            r = new java.awt.Rectangle(this.getX1(), this.getY1(), this.getX2() - this.getX1(), this.getY2() - this.getY1());
        } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) {
            r = new java.awt.Rectangle(this.getX2(), this.getY2(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
        } else if (this.getX1() > this.getX2() && this.getY1() < this.getY2()) {
            r = new java.awt.Rectangle(this.getX2(), this.getY1(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
        } else if (this.getX1() < this.getX2() && this.getY1() > this.getY2()) {
            r = new java.awt.Rectangle(this.getX1(), this.getY2(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));

        }

        if (r.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }
}
