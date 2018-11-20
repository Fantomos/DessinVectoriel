/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;


/**
 *
 * @author Nicolas
 */
public class SceneDessin extends JPanel implements MouseListener{
     private ArrayList<Figure> figuresScene;
   

    public ArrayList<Figure> getfiguresScene() {
        return figuresScene;
    }

    public void getfiguresScene(ArrayList<Figure> contient) {
        this.figuresScene = contient;
    }

    public SceneDessin() {
        this.figuresScene = new ArrayList<Figure>();
        this.addMouseListener(this);
    }
    
    public void eclaterEnsemble(EnsembleFigures ef) {
        this.figuresScene.addAll(ef.getTabFigures());
        ef.getTabFigures().clear();
    }
    
    
      @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < this.figuresScene.size(); i++) {
            Figure cur = this.figuresScene.get(i);
            cur.dessine(g);
        }
}
   
  
    

   
    
   
    
    public static SceneDessin sceneTest(int nbr) {
        SceneDessin res = new SceneDessin();
   
          
            res.figuresScene.add(
                        new Point(
                                Math.random() * 400,
                                Math.random() * 400,"point",new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           res.figuresScene.add(new Segment (new Point(Math.random() * 400, Math.random() * 400), new Point(Math.random() * 400,Math.random() * 400),"segment",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           
           res.figuresScene.add(new Cercle (new Point(Math.random() * 400, Math.random() * 400), Math.random()*100,"cercle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            res.figuresScene.add(new Ellipse (new Point(Math.random() * 400, Math.random() * 400), Math.random()*100,Math.random()*100,"cercle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            ArrayList<Point> sommet = new ArrayList<Point>();
           for(int i =0; i<5;i++){
               sommet.add(new Point(Math.random() * 200, Math.random() * 200));
           }
            res.figuresScene.add(new Polygone(sommet,"polygone",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));

            res.figuresScene.add(new Rectangle(new Point(Math.random() * 400, Math.random() * 400),100,300,"Rectangle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            
            ArrayList<Point> sommet2 = new ArrayList<Point>();
           for(int i =0; i<5;i++){
               sommet2.add(new Point(Math.random() * 200, Math.random() * 200));
           }
            res.figuresScene.add(new Polyligne(sommet2,"polygone",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            
        
        return res;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

   
}
