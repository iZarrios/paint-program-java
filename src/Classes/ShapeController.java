/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Graphics;

/**
 *
 * @author zeyad
 */
public class ShapeController {

    public static Shape shapeInstance(Shape s) {
        if (s instanceof Line) {
            return (Line) s;
        } else if (s instanceof Brush) {
            return (Brush) s;
        } else if (s instanceof Square) {
            return (Square) s;
        } else if (s instanceof Circle) {
            return (Circle) s;
        } else if (s instanceof Ellipse) {
            return (Ellipse) s;
        } else if (s instanceof Oval) {
            return (Oval) s;
        } else if (s instanceof Rectangle) {
            return (Rectangle) s;
        } else if (s instanceof RoundedRectangle) {
            return (RoundedRectangle) s;
        } else if (s instanceof Triangle) {
            return (Triangle) s;
        } else if (s instanceof Sector) {
            return (Sector) s;
        } else if (s instanceof Diamond) {
            return (Diamond) s;
        } else if (s instanceof Polygon) {
            return (Polygon) s;
        }
        return null;
    }

    public static void ShapeManipulator(Graphics graph, Shape s) {
        //allShapes.get(i).draw(g);
        if (s instanceof Line) {
            Line l = (Line) s;
            l.draw(graph, l);
        } else if (s instanceof Brush) {
            Brush b = (Brush) s;
            b.draw(graph, b);
        } else if (s instanceof Square) {
            Square sq = (Square) s;
            sq.draw(graph, sq);
        } else if (s instanceof Circle) {
            Circle e = (Circle) s;
            e.draw(graph, e);
        } else if (s instanceof Ellipse) {
            Ellipse e = (Ellipse) s;
            e.draw(graph, e);
        } else if (s instanceof Oval) {
            Oval o = (Oval) s;
            o.draw(graph, o);
        } else if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            r.draw(graph, r);
        } else if (s instanceof RoundedRectangle) {
            RoundedRectangle rR = (RoundedRectangle) s;
            rR.draw(graph, rR);
        } else if (s instanceof Triangle) {
            Triangle t = (Triangle) s;
            t.draw(graph, t);
        } else if (s instanceof Sector) {
            Sector ss = (Sector) s;
            ss.draw(graph, ss);
        } else if (s instanceof Diamond) {
            Diamond ss = (Diamond) s;
            ss.draw(graph, ss);
        } else if (s instanceof Polygon) {
            Polygon poly = (Polygon) s;
            poly.draw(graph, poly);
        }
    }
}
