/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author START
 */
public class RoundedRectangle extends Shape {

    /**
     * @return the arcWidth
     */
    public int getArcWidth() {
        return arcWidth;
    }

    /**
     * @param arcWidth the arcWidth to set
     */
    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    /**
     * @return the arcHeight
     */
    public int getArcHeight() {
        return arcHeight;
    }

    /**
     * @param arcHeight the arcHeight to set
     */
    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    private int x1, y1;
    private int x2, y2;
    private boolean fillColor = false;
    private int arcWidth;
    private int arcHeight;

    public boolean isFillColor() {
        return fillColor;
    }

    public void settFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    public RoundedRectangle(int x1, int y1, int x2, int y2, int arcWidth, int arcHeight, Color color, boolean nextfillColor) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fillColor = nextfillColor;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    public RoundedRectangle(){}
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

    @Override
    public void draw(Graphics graph, Shape x) {
        RoundedRectangle rr = (RoundedRectangle) x;
        graph.setColor(rr.getColor());
        if (x.isFillColor()) {
            if (rr.getX1() < rr.getX2() && rr.getY1() < rr.getY2()) {//case A
                graph.fillRoundRect(rr.getX1(), rr.getY1(), rr.getX2() - rr.getX1(), rr.getY2() - rr.getY1(), rr.getArcWidth(), rr.getArcHeight());
            } else if (rr.getX1() > rr.getX2() && rr.getY1() > rr.getY2()) {
                graph.fillRoundRect(rr.getX2(), rr.getY2(), Math.abs(rr.getX2() - rr.getX1()), Math.abs(rr.getY2() - rr.getY1()), rr.getArcWidth(), rr.getArcHeight());
            } else if (rr.getX1() > rr.getX2() && rr.getY1() < rr.getY2()) {
                graph.fillRoundRect(rr.getX2(), rr.getY1(), Math.abs(rr.getX2() - rr.getX1()), Math.abs(rr.getY2() - rr.getY1()), rr.getArcWidth(), rr.getArcHeight());
            } else if (rr.getX1() < rr.getX2() && rr.getY1() > rr.getY2()) {
                graph.fillRoundRect(rr.getX1(), rr.getY2(), Math.abs(rr.getX2() - rr.getX1()), Math.abs(rr.getY2() - rr.getY1()), rr.getArcWidth(), rr.getArcHeight());
            }
        } else {
            if (rr.getX1() < rr.getX2() && rr.getY1() < rr.getY2()) {//case A
                graph.drawRoundRect(rr.getX1(), rr.getY1(), rr.getX2() - rr.getX1(), rr.getY2() - rr.getY1(), rr.getArcWidth(), rr.getArcHeight());
            } else if (rr.getX1() > rr.getX2() && rr.getY1() > rr.getY2()) {
                graph.drawRoundRect(rr.getX2(), rr.getY2(), Math.abs(rr.getX2() - rr.getX1()), Math.abs(rr.getY2() - rr.getY1()), rr.getArcWidth(), rr.getArcHeight());
            } else if (rr.getX1() > rr.getX2() && rr.getY1() < rr.getY2()) {
                graph.drawRoundRect(rr.getX2(), rr.getY1(), Math.abs(rr.getX2() - rr.getX1()), Math.abs(rr.getY2() - rr.getY1()), rr.getArcWidth(), rr.getArcHeight());
            } else if (rr.getX1() < rr.getX2() && rr.getY1() > rr.getY2()) {
                graph.drawRoundRect(rr.getX1(), rr.getY2(), Math.abs(rr.getX2() - rr.getX1()), Math.abs(rr.getY2() - rr.getY1()), rr.getArcWidth(), rr.getArcHeight());
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
