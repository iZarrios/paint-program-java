/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Sector extends Shape {

    private int x1, y1;
    private int x2, y2;
    private boolean fillColor = false;

    public Sector(int x1, int y1, int x2, int y2, Color color, boolean fillColor) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fillColor = fillColor;
    }

    public boolean isFillColor() {
        return fillColor;
    }

    public void setFillColor(boolean fillColor) {
        this.fillColor = fillColor;
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

    @Override
    public void draw(Graphics graph, Shape x) {
        Sector sec = (Sector) x;
        graph.setColor(sec.getColor());
        if (x.isFillColor()) {
            if (sec.getX1() > sec.getX2()) {
                graph.fillArc(sec.getX1(), sec.getY1(), sec.getX2(), sec.getY2(), (int) (sec.getX2() - sec.getX1() * 2 / 360 * Math.PI), (int) -(sec.getY2() - sec.getY1() * 2 / 360 * Math.PI));
            } else {
                graph.drawArc(sec.getX1(), sec.getY1(), sec.getX2(), sec.getY2(), 90, 180);
            }
        }else{
          System.err.println("Error!");
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
