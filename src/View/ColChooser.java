/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.ColorChooserComponentFactory;

/**
 *
 * @author START
 */
public class ColChooser extends javax.swing.JColorChooser implements MouseListener, MouseMotionListener{
    private Color color;
    
    public ColChooser() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void mouseClicked(MouseEvent me) {Board.currentColor= getColor();
       View.Board.currentColor= getColor();
    }

    @Override
    public void mousePressed(MouseEvent e) {Board.currentColor= getColor();
        Board.currentColor= getColor();
    }

    @Override
    public void mouseReleased(MouseEvent e) {Board.currentColor= getColor();
    }

    @Override
    public void mouseEntered(MouseEvent e) {Board.currentColor= getColor();
    }

    @Override
    public void mouseExited(MouseEvent e) {System.out.println("55555");Board.currentColor= getColor();
    System.out.println(getColor());System.out.println(Board.currentColor);
    }

    @Override
    public void mouseDragged(MouseEvent e) {Board.currentColor= getColor();
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {Board.currentColor= getColor();
       
    }
}
