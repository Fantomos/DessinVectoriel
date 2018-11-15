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
import javax.swing.*;

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
    
    public void supprimeEnsemble(EnsembleFigures ef) {
        this.figuresScene.addAll(ef.getTabFigures());
        ef.getTabFigures().clear();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < this.getfiguresScene().size(); i++) {
            Figure cur = this.getfiguresScene().get(i);
            cur.dessine(g);
        }
    }
    
    
   
    @Override
    public void mouseClicked(MouseEvent e) {
        // todo
        
        System.out.println(this.getfiguresScene().get(4).distancePoint(new Point(e.getX(),e.getY())));
    
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
    
    public static void main(String[] args) {
        JFrame f = new JFrame("test point");
        f.setSize(600, 400);
        // l'instruction ci-dessous indique que l'on veut
        // arréter l'application lorsque l'on ferme la fenetre
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SceneDessin s = SceneDessin.sceneTest(20);

        f.add(s);
        f.setVisible(true);

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
            
            res.figuresScene.add(new Segment (new Point(-400, 0), new Point(400,0),"segment", new Color(0,0,0)));
            res.figuresScene.add(new Segment (new Point(0, -400), new Point(0,400),"segment",
                        new Color(0,0,0)));
        
        return res;
    }
    
}
