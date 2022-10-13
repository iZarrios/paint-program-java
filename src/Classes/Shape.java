/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Shape extends ShapeClone implements Container {

    private int x1, y1;
    private int x2, y2;

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
    public Shape(){};

    public abstract boolean contains(int x, int y);
    private Color color;
    private boolean fillColor = false;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColor(Color color, boolean fillColor) {
        this.color = color;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public boolean isFillColor() {
        return fillColor;
    }

    public void setFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    //decorater DESGIN PATTERN
    public void draw(Graphics graph, Shape x) {
    }

    @Override
    public Iterator getIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ShapeIterator implements Iterator {

        int index;
        ArrayList<Shape> allShapes = new ArrayList();

        @Override
        public boolean hasNext() {

            if (index < allShapes.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return allShapes.get(index + 1);
            }
            return null;
        }
    }

}
