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
public class Brush extends Shape {


    private int x1, y1;
    private boolean fillColor = false;
    private int brushSize;

    @Override
    public boolean isFillColor() {
        return fillColor;
    }

    public void settFillColor(boolean fillColor) {
        this.setFillColor(fillColor);
    }

    public Brush(double x1, double y1,String brushSize, Color color, boolean nextfillColor) {
        super(color);
        try{
        this.brushSize=Integer.parseInt(brushSize);
        }catch(NumberFormatException e ){
            this.brushSize=10;
        }
        this.x1 = (int) (x1 - this.brushSize /2);
        this.y1 = (int) (y1 - this.brushSize /2);
        this.fillColor = nextfillColor;
    }

    @Override
    public void draw(Graphics graph, Shape x) {
        Brush b = (Brush) x;
        graph.setColor(b.getColor());
        graph.fillRoundRect(b.getX1(), b.getY1(), b.getBrushSize(),b.getBrushSize(),b.getBrushSize(),b.getBrushSize());  
        
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @param fillColor the fillColor to set
     */
    @Override
    public void setFillColor(boolean fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * @return the brushSize
     */
    public int getBrushSize() {
        return brushSize;
    }

    /**
     * @param brushSize the brushSize to set
     */
    public void setBrushSize(int brushSize) {
        this.brushSize = brushSize;
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

