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
 * @author zeyad
 */
public class Oval extends Shape{

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

    public boolean isFillColor() {
        return fillColor;
    }

    public void setFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }
    private int x1, y1;
    private int x2, y2;
    private boolean fillColor = false;
    public Oval(int x1, int y1, int x2, int y2, Color color,boolean nextfillColor){
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fillColor = nextfillColor;
    }
    public Oval(){}
public void draw(Graphics graph, Shape x) {
     Oval o = (Oval) x;
                graph.setColor(o.getColor());
                if (x.isFillColor()){
                    if (o.getX1() < o.getX2() && o.getY1() < o.getY2()) {//case A
                    graph.fillOval(o.getX1(), o.getY1(), o.getX2() - o.getX1(), o.getY2() - o.getY1());
                } else if (o.getX1() > o.getX2() && o.getY1() > o.getY2()) {
                    graph.fillOval(o.getX2(), o.getY2(), Math.abs(o.getX2() - o.getX1()), Math.abs(o.getY2() - o.getY1()));
                }else if (o.getX1() > o.getX2() && o.getY1() < o.getY2()){
                    graph.fillOval(o.getX2(), o.getY1(), Math.abs(o.getX2() - o.getX1()), Math.abs(o.getY2() - o.getY1()));
                }else if (o.getX1() < o.getX2() && o.getY1() > o.getY2()){
                    graph.fillOval(o.getX1(), o.getY2(), Math.abs(o.getX2() - o.getX1()), Math.abs(o.getY2() - o.getY1()));
                }
                }else{
                    if (o.getX1() < o.getX2() && o.getY1() < o.getY2()) {//case A
                    graph.drawOval(o.getX1(), o.getY1(), o.getX2() - o.getX1(), o.getY2() - o.getY1());
                } else if (o.getX1() > o.getX2() && o.getY1() > o.getY2()) {
                    graph.drawOval(o.getX2(), o.getY2(), Math.abs(o.getX2() - o.getX1()), Math.abs(o.getY2() - o.getY1()));
                }else if (o.getX1() > o.getX2() && o.getY1() < o.getY2()){
                    graph.drawOval(o.getX2(), o.getY1(), Math.abs(o.getX2() - o.getX1()), Math.abs(o.getY2() - o.getY1()));
                }else if (o.getX1() < o.getX2() && o.getY1() > o.getY2()){
                    graph.drawOval(o.getX1(), o.getY2(), Math.abs(o.getX2() - o.getX1()), Math.abs(o.getY2() - o.getY1()));
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
