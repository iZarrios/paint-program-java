/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author USER
 */
public class Save {
    public static BufferedImage getscreenshot(Component component){
        BufferedImage image=new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;   
    }
    public static void SaveScreenShoot(Component component,String filename)throws Exception{
        BufferedImage img=getscreenshot(component);
        ImageIO.write(img,"png",new File(filename));
    }
    
}
