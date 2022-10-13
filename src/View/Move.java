/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Rectangle;
import Classes.Shape;
import Classes.ShapeController;

/**
 *
 * @author START
 */
public class Move {
    private static Move instance = new Move();
    private Move(){}
    
    public static Move getInstance(){
        return instance;
    }

    public void  move(Shape h,int x1,int x2,int y1,int y2) {
        Shape s = ShapeController.shapeInstance((h));
        if(x2>x1&&y2>y1){
            s.setX1(s.getX1()+(x2-x1));
            s.setX2(s.getX2()+(x2-x1));
            s.setY1(s.getY1()+(y2-y1));
            s.setY2(s.getY2()+(y2-y1));
        }else if(x2<x1&&y2>y1){
            s.setX1(s.getX1()-(x1-x2));
            s.setX2(s.getX2()-(x1-x2));
            s.setY1(s.getY1()+(y2-y1));
            s.setY2(s.getY2()+(y2-y1));
        }else if(x2>x1&&y2<y1){
            s.setX1(s.getX1()+(x2-x1));
            s.setX2(s.getX2()+(x2-x1));
            s.setY1(s.getY1()-(y1-y2));
            s.setY2(s.getY2()-(y1-y2));
        }
        else if(x2<x1&&y2<y1){
            s.setX1(s.getX1()-(x1-x2));
            s.setX2(s.getX2()-(x1-x2));
            s.setY1(s.getY1()-(y1-y2));
            s.setY2(s.getY2()-(y1-y2));
        }
        else if(x2>x1){
            s.setX1(s.getX1()+(x2-x1));
            s.setX2(s.getX2()+(x2-x1));
        }
        else if(x2<x1){
            s.setX1(s.getX1()-(x1-x2));
            s.setX2(s.getX2()-(x1-x2));
        }
        else if(y2>y1){
            s.setY1(s.getY1()+(y2-y1));
            s.setY2(s.getY2()+(y2-y1));
        }
        else if(y2<y1){
            s.setY1(s.getY1()-(y1-y2));
            s.setY2(s.getY2()-(y1-y2));
        }
    }
}