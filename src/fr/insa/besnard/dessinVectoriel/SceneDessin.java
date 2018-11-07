/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class SceneDessin {
     private ArrayList<Figure> contient;

    public ArrayList<Figure> getContient() {
        return contient;
    }

    public void setContient(ArrayList<Figure> contient) {
        this.contient = contient;
    }

    public SceneDessin() {
        this.contient = new ArrayList<Figure>();
    }
    
    
    public static SceneDessin sceneTest(int nbr) {
        SceneDessin res = new SceneDessin();
   
          
            res.contient.add(
                        new Point(
                                Math.random() * 400,
                                Math.random() * 400,"point",new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           res.contient.add(new Segment (new Point(Math.random() * 400, Math.random() * 400), new Point(Math.random() * 400,Math.random() * 400),"segment",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           
           res.contient.add(new Cercle (new Point(Math.random() * 400, Math.random() * 400), Math.random()*400,"cercle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           
            ArrayList<Point> sommet = new ArrayList<Point>();
           for(int i =0; i<5;i++){
               sommet.add(new Point(Math.random() * 400, Math.random() * 400));
           }
            res.contient.add(new Polygone(sommet,"polygone",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));

            res.contient.add(new Rectangle(new Point(Math.random() * 400, Math.random() * 400),100,300,"Rectangle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
        
        return res;
    }
    
}
