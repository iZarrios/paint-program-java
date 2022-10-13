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
public class Ellipse  extends Shape{
    private int x1, y1;
    private int x2, y2;
    private boolean fillColor = false;
    private final static int ARCWIDTH=90;
    private final static int  ARCHEIGHT=1000;
    
       public int getArcWidth() {
        return ARCWIDTH;
    }

    /**
     * @param arcWidth the arcWidth to set
     */


    /**
     * @return the arcHeight
     */
    public int getArcHeight() {
        return ARCHEIGHT;
    }

    /**
     * @param arcHeight the arcHeight to set
     */

   

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

    public void settFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    public Ellipse(int x1, int y1, int x2, int y2, Color color, boolean nextfillColor) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.fillColor = nextfillColor;
    }

    public Ellipse(){}
    public void draw(Graphics graph, Shape x) {
        Ellipse e = (Ellipse) x;
                graph.setColor(e.getColor());
                if (x.isFillColor()){
                    if (e.getX1() < e.getX2() && e.getY1() < e.getY2()) {//case A
                    graph.fillRoundRect(e.getX1(), e.getY1(), e.getX2() - e.getX1(), e.getY2() - e.getY1(),e.getArcWidth(),e.getArcHeight());
                } else if (e.getX1() > e.getX2() && e.getY1() > e.getY2()) {
                    graph.fillRoundRect(e.getX2(), e.getY2(), Math.abs(e.getX2() - e.getX1()), Math.abs(e.getY2() - e.getY1()),e.getArcWidth(),e.getArcHeight());
                }else if (e.getX1() > e.getX2() && e.getY1() < e.getY2()){
                    graph.fillRoundRect(e.getX2(), e.getY1(), Math.abs(e.getX2() - e.getX1()), Math.abs(e.getY2() - e.getY1()),e.getArcWidth(),e.getArcHeight());
                }else if (e.getX1() < e.getX2() && e.getY1() > e.getY2()){
                    graph.fillRoundRect(e.getX1(), e.getY2(), Math.abs(e.getX2() - e.getX1()), Math.abs(e.getY2() - e.getY1()),e.getArcWidth(),e.getArcHeight());
                }
                }else{
                    if (e.getX1() < e.getX2() && e.getY1() < e.getY2()) {//case A
                    graph.drawRoundRect(e.getX1(), e.getY1(), e.getX2() - e.getX1(), e.getY2() - e.getY1(),e.getArcWidth(),e.getArcHeight());
                } else if (e.getX1() > e.getX2() && e.getY1() > e.getY2()) {
                    graph.drawRoundRect(e.getX2(), e.getY2(), Math.abs(e.getX2() - e.getX1()), Math.abs(e.getY2() - e.getY1()),e.getArcWidth(),e.getArcHeight());
                }else if (e.getX1() > e.getX2() && e.getY1() < e.getY2()){
                    graph.drawRoundRect(e.getX2(), e.getY1(), Math.abs(e.getX2() - e.getX1()), Math.abs(e.getY2() - e.getY1()),e.getArcWidth(),e.getArcHeight());
                }else if (e.getX1() < e.getX2() && e.getY1() > e.getY2()){
                    graph.drawRoundRect(e.getX1(), e.getY2(), Math.abs(e.getX2() - e.getX1()), Math.abs(e.getY2() - e.getY1()),e.getArcWidth(),e.getArcHeight());
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
