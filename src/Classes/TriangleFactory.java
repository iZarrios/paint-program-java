/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author eyad4
 */
public class TriangleFactory extends AbstractFactory {

    @Override
    public Shape CreateShape(String name) {
        if (name.equals("Triangle")) {
            return new Triangle();
        } else if (name.equals("RightTriangle")) {
            return new Triangle(true);
        } else {
            return null;
        }
    }

}
