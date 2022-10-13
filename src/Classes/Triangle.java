/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

    private int x1, y1;
    private int x2, y2;
    private int x3, y3;
    private boolean fillColor = false;
    private boolean isRight = false;
    public Triangle(){}
    public Triangle(boolean isRight){}

    @Override
    public boolean isFillColor() {
        return fillColor;
    }

    public boolean isIsRight() {
        return isRight;
    }

    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public void settFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color, boolean nextfillColor, boolean isRight) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.fillColor = nextfillColor;
        this.isRight = isRight;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color, boolean nextfillColor) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
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

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }
//        @Override

    @Override
    public void draw(Graphics graph, Shape x) {
        Triangle t = (Triangle) x;
        graph.setColor(t.getColor());
        if (t.isIsRight() == false) {
            if (x.isFillColor()) {
                graph.fillPolygon(new int[]{t.getX1(), (t.getX1() + t.getX2()) / 2, t.getX2()}, new int[]{t.getY2(), t.getY1(), t.getY2()}, 3);
            } else {
                graph.drawPolygon(new int[]{t.getX1(), (t.getX1() + t.getX2()) / 2, t.getX2()}, new int[]{t.getY2(), t.getY1(), t.getY2()}, 3);
            }
        } else {
            if (x.isFillColor()) {
                graph.fillPolygon(new int[]{t.getX1(), t.getX2(), t.getX2()}, new int[]{t.getY2(), t.getY1(), t.getY2()}, 3);
            } else {
                graph.drawPolygon(new int[]{t.getX1(), t.getX2(), t.getX2()}, new int[]{t.getY2(), t.getY1(), t.getY2()}, 3);
            }
        }
    }

    @Override
    public boolean contains(int x, int y) {
            java.awt.Rectangle r=new java.awt.Rectangle();
            if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) {
                  r = new java.awt.Rectangle(this.getX1(), this.getY1(), this.getX2() - this.getX1(),this.getY2() - this.getY1());
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) {
                  r = new java.awt.Rectangle(this.getX2(), this.getY2(), Math.abs(this.getX2() - this.getX1()),Math.abs(this.getY2() - this.getY1()));
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
