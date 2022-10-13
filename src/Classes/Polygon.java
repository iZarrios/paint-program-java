/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author eyad4
 */
public class Polygon extends Shape {

    private int x1, y1;

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
    private int x2, y2;
    private boolean fillColor = false;

    public boolean isFillColor() {
        return fillColor;
    }

    public void settFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    public Polygon(int x1, int y1, int x2, int y2, Color color, boolean nextfillColor) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fillColor = nextfillColor;
    }

    @Override
    public void draw(Graphics graph, Shape shape) {
        Polygon poly = (Polygon) shape;
        graph.setColor(poly.getColor());
        graph.drawLine(poly.getX1(), poly.getY1(), poly.getX2(), poly.getY2());

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
