/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Brush;
import Classes.Circle;
import Classes.Diamond;
import Classes.Ellipse;
import Classes.Line;
import Classes.Oval;
import Classes.Polygon;
import Classes.Rectangle;
import Classes.RoundedRectangle;
import Classes.Sector;
import Classes.Shape;
import Classes.ShapeController;
import Classes.Square;
import Classes.Triangle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import Classes.SHAPES;
import java.util.Iterator;

public class Board extends JPanel implements MouseListener, MouseMotionListener {

    static Color currentColor = Color.BLACK;
    private int mode = -1;//0 for line 1 for rect
    private int x1;
    private int y1;
    private boolean first = false;
    private int x2;
    private int y2;
    private boolean nextfillColor = false;
    private int Index = 0;
    private int maxIndex = 0;
    private static String brushSize;
    private Shape selectedShape = null;
    private int shiftX;
    private int shiftY;
    private boolean flagPolygon = true;
    private int x_polygon = 0;
    private int y_polygon = 0;

    /**
     * @return the shiftX
     */
    public int getShiftX() {
        return shiftX;
    }

    /**
     * @param shiftX the shiftX to set
     */
    public void setShiftX(int shiftX) {
        this.shiftX = shiftX;
    }

    /**
     * @return the shiftY
     */
    public int getShiftY() {
        return shiftY;
    }

    /**
     * @param shiftY the shiftY to set
     */
    public void setShiftY(int shiftY) {
        this.shiftY = shiftY;
    }

    public static String getBrushSize() {
        return brushSize;
    }

    public static void setBrushSize(String brushSize) {
        Board.brushSize = brushSize;
    }

    public boolean isNextFillColor() {
        return isNextfillColor();
    }

    public void setNextFillColor(boolean fillColor) {
        this.setNextfillColor(fillColor);
    }

    private ArrayList<Shape> allShapes = new ArrayList<Shape>();
    //design pattern 
    Iterator<Shape> iter = allShapes.iterator();

    //Design Pattern Singleton--------------------------------------------------
    public Board() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        for (int i = 0; i < getIndex(); i++) //Solid Principle Open-Close---------------------------------------
        //Design Pattern Factory-------------------------------------------
        {
            ShapeController.ShapeManipulator(graph, allShapes.get(i));
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        setX1(me.getX());
        setY1(me.getY());
        switch (getMode()) {
            case SHAPES.LINE:
                Line l = new Line(getX1(), getY1(), getX1(), getY1(), getCurrentColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, l);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(l);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.RECTANGLE:
                Rectangle re = new Rectangle(x1, y1, x1, y1, currentColor, isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, re);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(re);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.ROUNDEDRECTANGLE:
                RoundedRectangle rR = new RoundedRectangle(getX1(), getY1(), getX1(), getY1(), 90, 50, getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, rR);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(rR);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.CIRCLE:
                Circle c = new Circle(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, c);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(c);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.ELLIPSE:
                Ellipse e = new Ellipse(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, e);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(e);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.OVAL:
                Oval o = new Oval(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, o);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(o);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.SQUARE:
                Square sq = new Square(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, sq);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(sq);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.TRIANGLE:
                Triangle t = new Triangle(getX1(), getY1(), getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, t);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(t);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.RIGHTTRIANGLE:
                Triangle rT = new Triangle(getX1(), getY1(), getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor(), true);
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, rT);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(rT);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;

            case SHAPES.SECTOR:
                Sector sec = new Sector(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, sec);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(sec);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;

            case SHAPES.POLYGON:

                if (flagPolygon) {
                    flagPolygon = false;
                    x_polygon = getX1();
                    y_polygon = getY1();
                    Polygon poly = new Polygon(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                    if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                        System.out.println("rewrite");
                        allShapes.set(Index, poly);
                        setIndex(getIndex() + 1);
                        setMaxIndex(getMaxIndex() + 1);
                        maxIndex = Index;
                        for (int i = Index + 1; i < allShapes.size(); i++) {
                            allShapes.remove(i);
                        }
                    } else {
                        Index++;
                        maxIndex++;
                        allShapes.add(poly);
                        System.out.println("new");
                    }
                    repaint();
                    System.out.println("index" + Index);
                    System.out.println("maxIndex" + maxIndex);
                } else {

                    System.out.println("View.Board.mousePressed()");
                    int x = allShapes.get(getMaxIndex() - 1).getX2();
                    int y = allShapes.get(getMaxIndex() - 1).getY2();
                    if (Math.abs(x_polygon - x) <= 75 && Math.abs(y_polygon - y) <= 75) {
                        System.out.println("help me please ;-;");
                        flagPolygon = true;

                    } else {
                        flagPolygon = false;
                    }
                    Polygon p2 = new Polygon(x, y, x, y, getCurrentColor(), isNextFillColor());
//                        p2.setFlag(false);

                    if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                        System.out.println("rewrite");
                        allShapes.set(Index, p2);
                        setIndex(getIndex() + 1);
                        setMaxIndex(getMaxIndex() + 1);
                        maxIndex = Index;
                        for (int i = Index + 1; i < allShapes.size(); i++) {
                            allShapes.remove(i);
                        }
                    } else {
                        Index++;
                        maxIndex++;
                        allShapes.add(p2);
                        System.out.println("new");
                    }
                    repaint();
                    System.out.println("index" + Index);
                    System.out.println("maxIndex" + maxIndex);

                }
                break;
            case SHAPES.BRUSH:
                Brush b = new Brush(getX1(), getY1(), getBrushSize(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, b);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(b);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.DIAMOND:
                Diamond dia = new Diamond(getX1(), getY1(), getX1(), getY1(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex() || getMaxIndex() < allShapes.size()) {//Prevent Bugs in Undo
                    System.out.println("rewrite");
                    allShapes.set(Index, dia);
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    maxIndex = Index;
                    for (int i = Index + 1; i < allShapes.size(); i++) {
                        allShapes.remove(i);
                    }
                } else {
                    Index++;
                    maxIndex++;
                    allShapes.add(dia);
                    System.out.println("new");
                }
                repaint();
                System.out.println("index" + Index);
                System.out.println("maxIndex" + maxIndex);
                break;
            case SHAPES.RESIZE:
                for (int i = getAllShapes().size() - 1; i >= 0; i--) {
                    if (getAllShapes().get(i).contains(x1, y1)) {
                        setSelectedShape(getAllShapes().get(i));
                        System.out.println("selected");
                        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                    } else {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
                repaint();
                break;
            case SHAPES.COPY:
                for (int i = getAllShapes().size() - 1; i >= 0; i--) {
                    if (getAllShapes().get(i).contains(getX1(), getY1())) {
                        setSelectedShape(getAllShapes().get(i));
                        try {
                            Shape x = getSelectedShape();
                            Shape s = (Shape) x.clone();
                            System.out.println("Before :" + " " + s.getX1() + " " + s.getX2() + " " + s.getY1() + " " + s.getY2());

                            s.setX1(x.getX1() + getShiftX());
                            s.setY1(x.getY1() + getShiftY());
                            s.setX2(x.getX2() + getShiftX());
                            s.setY2(x.getY2() + getShiftY());
                            setIndex(getIndex() + 1);
                            setMaxIndex((getMaxIndex() + 1));
                            System.out.println("After :" + " " + s.getX1() + " " + s.getX2() + " " + s.getY1() + " " + s.getY2());
                            allShapes.add(s);

                        } catch (CloneNotSupportedException cloneNotSupportedException) {
                            cloneNotSupportedException.printStackTrace();
                        }
                        System.out.println("selected");
                        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                        break;
                    } else {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
                repaint();
                break;
            case SHAPES.DELETE:
                for (int i = allShapes.size() - 1; i >= 0; i--) {
                    if (allShapes.get(i).contains(x1, y1)) {
                        selectedShape = allShapes.get(i);
                        System.out.println("selected");
                        break;
                    }
                }
                allShapes.remove(getSelectedShape());
                setIndex(getIndex() - 1);
                setMaxIndex(getMaxIndex() - 1);
                repaint();
                break;
            case SHAPES.MOVE:
                for (int i = allShapes.size() - 1; i >= 0; i--) {
                    if (allShapes.get(i).contains(x1, y1)) {
                        selectedShape = allShapes.get(i);
                        System.out.println("selected");
                        break;
                    }
                }
            default:
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(mode==SHAPES.POLYGON){
            int x = allShapes.get(getMaxIndex() - 1).getX2();
            int y = allShapes.get(getMaxIndex() - 1).getY2();
            if (Math.abs(x_polygon - x) <= 75 && Math.abs(y_polygon - y) <= 75) {
                flagPolygon = true;

            } else {
                flagPolygon = false;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        switch (getMode()) {
            case SHAPES.LINE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Line) {
                    Line l = (Line) s;
                    l.setX2(getX2());
                    l.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.RECTANGLE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Rectangle) {
                    Rectangle r = (Rectangle) s;
                    r.setX2(getX2());
                    r.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.ROUNDEDRECTANGLE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof RoundedRectangle) {
                    RoundedRectangle r = (RoundedRectangle) s;
                    r.setX2(getX2());
                    r.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.CIRCLE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Circle) {
                    Circle c = (Circle) s;
                    c.setX2(getX2());
                    c.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.ELLIPSE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Ellipse) {
                    Ellipse e = (Ellipse) s;
                    e.setX2(getX2());
                    e.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.OVAL: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Oval) {
                    Oval o = (Oval) s;
                    o.setX2(getX2());
                    o.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.SQUARE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Square) {
                    Square sq = (Square) s;
                    sq.setX2(getX2());
                    sq.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.TRIANGLE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Triangle) {
                    Triangle t = (Triangle) s;
                    t.setX2(getX2());
                    t.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.RIGHTTRIANGLE: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Triangle) {
                    Triangle rT = (Triangle) s;
                    rT.setX2(getX2());
                    rT.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.SECTOR: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Sector) {
                    Sector ss = (Sector) s;
                    ss.setX2(getX2());
                    ss.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.POLYGON: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Polygon) {
                    Polygon poly = (Polygon) s;
                    poly.setX2(getX2());
                    poly.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.BRUSH: {
                setX2(me.getX());
                setY2(me.getY());
                Brush b = new Brush(getX2(), getY2(), getBrushSize(), getCurrentColor(), isNextFillColor());
                if (getIndex() < getMaxIndex()) {//Prevent Bugs in Undo
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    getAllShapes().set(getIndex(), b);
                    setMaxIndex(getIndex());
                } else {
                    setIndex(getIndex() + 1);
                    setMaxIndex(getMaxIndex() + 1);
                    getAllShapes().add(b);
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.DIAMOND: {
                setX2(me.getX());
                setY2(me.getY());
                Shape s = getAllShapes().get(getAllShapes().size() - 1);
                if (s instanceof Diamond) {
                    Diamond dia = (Diamond) s;
                    dia.setX2(getX2());
                    dia.setY2(getY2());
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.RESIZE: {
                if (getSelectedShape() != null) {
                    setX2(me.getX());
                    setY2(me.getY());
                    Shape s = getSelectedShape();
                    if (s instanceof Rectangle) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        System.out.println("Rectangle");
                        Rectangle r = (Rectangle) getSelectedShape();
                        r.setX1(getX1());
                        r.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();

                        //first = false; 
                    } else if (s instanceof Triangle) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        System.out.println("Triangle");
                        Triangle rT = (Triangle) getSelectedShape();

                        rT.setX1(getX1());
                        rT.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false;
                    } else if (s instanceof Line) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Line l = (Line) getSelectedShape();
                        l.setX1(getX1());
                        l.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    } else if (s instanceof RoundedRectangle) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        RoundedRectangle Rr = (RoundedRectangle) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    } else if (s instanceof Oval) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Oval Rr = (Oval) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }
                    else if (s instanceof Circle) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Circle Rr = (Circle) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }
                    else if (s instanceof Ellipse) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Ellipse Rr = (Ellipse) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }else if (s instanceof Diamond) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Diamond Rr = (Diamond) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }else if (s instanceof Sector) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Sector Rr = (Sector) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }else if (s instanceof Polygon) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Polygon Rr = (Polygon) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }else if (s instanceof Square) {
                        setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                        Square Rr = (Square) getSelectedShape();
                        Rr.setX1(getX1());
                        Rr.setY1(getY1());
                        setX1(getX2());
                        setY1(getY2());
                        repaint();
                        //first = false; 
                    }
                    
                }
                repaint();
                setFirst(false);
                break;
            }
            case SHAPES.COPY:

                break;
            case SHAPES.MOVE: {
                x2 = me.getX();
                y2 = me.getY();
                Shape s = getSelectedShape();
                if (selectedShape != null) {
                    Shape r = ShapeController.shapeInstance((s));
                    System.out.println("Before :" + " " + r.getX1() + " " + r.getX2() + " " + r.getY1() + " " + r.getY2());
                    //move( r, x1, x2, y1, y2);
                    Move n = Move.getInstance();
                    n.move(r, x1, x2, y1, y2);
                    System.out.println("After :" + " " + r.getX1() + " " + r.getX2() + " " + r.getY1() + " " + r.getY2());
                    x1 = x2;
                    y1 = y2;
                    repaint();;
                    break;
                }
            }
            default:
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    /**
     * @return the currentColor
     */
    public Color getCurrentColor() {
        return currentColor;
    }

    /**
     * @param currentColor the currentColor to set
     */
    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    /**
     * @return the mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(int mode) {
        this.mode = mode;
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
     * @return the first
     */
    public boolean isFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(boolean first) {
        this.first = first;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return the nextfillColor
     */
    public boolean isNextfillColor() {
        return nextfillColor;
    }

    /**
     * @param nextfillColor the nextfillColor to set
     */
    public void setNextfillColor(boolean nextfillColor) {
        this.nextfillColor = nextfillColor;
    }

    /**
     * @return the Index
     */
    public int getIndex() {
        return Index;
    }

    /**
     * @param Index the Index to set
     */
    public void setIndex(int Index) {
        this.Index = Index;
    }

    /**
     * @return the maxIndex
     */
    public int getMaxIndex() {
        return maxIndex;
    }

    /**
     * @param maxIndex the maxIndex to set
     */
    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    /**
     * @return the selectedShape
     */
    public Shape getSelectedShape() {
        return selectedShape;
    }

    /**
     * @param selectedShape the selectedShape to set
     */
    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    /**
     * @return the allShapes
     */
    public ArrayList<Shape> getAllShapes() {
        return allShapes;
    }

    /**
     * @param allShapes the allShapes to set
     */
    public void setAllShapes(ArrayList<Shape> allShapes) {
        this.allShapes = allShapes;
    }

}
