/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @author Nicolas
 */
public class SceneDessin extends JPanel implements MouseListener,MouseMotionListener{
    
    private ScenePrincipal main;
    private ArrayList<Figure> figuresScene;
    private boolean constructionSeg;
    private boolean constructionEllipse;
    private boolean constructionCercle;
    private boolean constructionRec;
    private boolean constructionPoly;
    private Segment stTemp;
    private Ellipse elTemp;
    private Cercle clTemp;
    private Rectangle recTemp;
    private ArrayList<Point> sommet;
    
    
    public void setConstructionEllipse(boolean constructionEllipse) {
        this.constructionEllipse = constructionEllipse;
    }

    public void setConstructionCercle(boolean constructionCercle) {
        this.constructionCercle = constructionCercle;
    }


    public void setConstructionSeg(boolean constructionSeg) {
        this.constructionSeg = constructionSeg;
    }

    public void setConstructionRec(boolean constructionRec) {
        this.constructionRec = constructionRec;
    }

    public void setConstructionPoly(boolean constructionPoly) {
        this.constructionPoly = constructionPoly;
    }

   

    public ArrayList<Figure> getfiguresScene() {
        return figuresScene;
    }

    public void getfiguresScene(ArrayList<Figure> contient) {
        this.figuresScene = contient;
    }

    public SceneDessin(ScenePrincipal main) {
        this.main = main;
        this.figuresScene = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.constructionEllipse = false;
        this.constructionCercle = false;
        this.constructionRec = false;
        this.constructionSeg = false;
        this.constructionPoly = false;
    
    }
    
    public void eclaterEnsemble(EnsembleFigures ef) {
        this.figuresScene.addAll(ef.getTabFigures());
        ef.getTabFigures().clear();
    }
    
    
      @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Dessine les figures dans le tableau
        for (int i = 0; i < this.figuresScene.size(); i++) {
            Figure cur = this.figuresScene.get(i);
            cur.dessine(g);
        }
        
        //Dessine les constructions
        if(this.constructionSeg == true){
            this.stTemp.dessine(g);
        }
        if(this.constructionEllipse == true){
            this.elTemp.dessine(g);
        }
         if(this.constructionCercle == true){
            this.clTemp.dessine(g);
        }
        if(this.constructionRec == true){
            this.recTemp.dessine(g);
        }
        if(this.constructionPoly == true){
            for(int i=0;i<sommet.size();i++){
                 this.sommet.get(i).dessine(g);
            }
        }
}
   
  
   

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // Si Bouton Point selectionné
        if(main.getMenu().getJbPoint().isSelected()){
            this.getfiguresScene().add(new Point(e.getX(),e.getY()));
            this.repaint();
        }
        
        // Si Bouton Segment selectionné
        else if(main.getMenu().getJbSegment().isSelected()){
            // Si premier clique
            if(this.constructionSeg == false){
                this.stTemp = new Segment(new Point(e.getX(),e.getY()),new Point(e.getX(),e.getY()));
                this.constructionSeg = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
               
            }
            // Si construction en cours
            else{
                this.figuresScene.add(this.stTemp);
                this.constructionSeg = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un segment");
            }
        
    }
         // Si Bouton Ellipse selectionné
         else if(main.getMenu().getJbEllipse().isSelected()){
             
            if(this.constructionEllipse == false){
                this.elTemp = new Ellipse(new Point(e.getX(),e.getY()),2,2);
                this.constructionEllipse = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
            }
             // Si construction en cours
            else{
                this.figuresScene.add(this.elTemp);
                this.constructionEllipse = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter une ellipse");
            }
    }
         // Si Bouton Cercle selectionné
         else if(main.getMenu().getJbCercle().isSelected()){
             
            if(this.constructionCercle == false){
                this.clTemp = new Cercle(new Point(e.getX(),e.getY()),0);
                this.constructionCercle = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
            }
             // Si construction en cours
            else{
                this.figuresScene.add(this.clTemp);
                this.constructionCercle = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un cercle");
            }
    }
         
         // Si Bouton Rectangle selectionné
         else if(main.getMenu().getJbRectangle().isSelected()){
             
            if(this.constructionRec == false){
                this.recTemp = new Rectangle(new Point(e.getX(),e.getY()),0,0);
                this.constructionRec = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
               
            }
             // Si construction en cours
            else{
                this.figuresScene.add(this.recTemp);
                this.constructionRec = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un rectangle");
            }
    }
         
          // Si Bouton Polygone selectionné
        else if(main.getMenu().getJbPolygone().isSelected()){
             
            if(this.constructionPoly == false){
                this.sommet = new ArrayList<Point>();
                sommet.add(new Point(e.getX(),e.getY()));
                this.constructionPoly = true;
                this.main.getInfo().getInfoText().setText("Clique droit pour ajouter des sommets. Clique gauche pour valider");
                this.repaint();
            }
             // Si construction en cours
            else{
                if(SwingUtilities.isRightMouseButton(e)){
                    if(sommet.size() > 2){
                    this.figuresScene.add(new Polygone(sommet));
                    }
                    this.constructionPoly = false;
                   this.repaint();
                   this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un polygone");
                }
                else{
                    this.sommet.add(new Point(e.getX(),e.getY()));
                    this.repaint();
                }
                
            }
        }
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

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    
        if(this.constructionSeg == true){
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.stTemp.setFin(new Point(p.x,p.y));
            this.repaint();
        }
        else if(this.constructionEllipse == true){
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.elTemp.setRayonX(p.x - this.elTemp.getPtSupGauche().getCoordx());
            this.elTemp.setRayonY(p.y - this.elTemp.getPtSupGauche().getCoordy());
            this.repaint();
        }
        else if(this.constructionCercle == true){
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
       
            this.clTemp.update(Math.max(p.y - this.clTemp.getPtSupGauche().getCoordy(),p.x - this.clTemp.getPtSupGauche().getCoordx()));
           
            this.repaint();
        }
        else if(this.constructionRec == true){
         
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.recTemp.update(p.y - recTemp.getSommet().get(0).getCoordy(),p.x - recTemp.getSommet().get(0).getCoordx());
          
            this.repaint();
        }
        
    }


 public void sceneTest(int nbr) {
       
   
          
            this.figuresScene.add(
                        new Point(
                                Math.random() * 400,
                                Math.random() * 400,"point",new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           this.figuresScene.add(new Segment (new Point(Math.random() * 400, Math.random() * 400), new Point(Math.random() * 400,Math.random() * 400),"segment",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
           
           this.figuresScene.add(new Cercle (new Point(Math.random() * 400, Math.random() * 400), Math.random()*100,"cercle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            this.figuresScene.add(new Ellipse (new Point(Math.random() * 400, Math.random() * 400), Math.random()*100,Math.random()*100,"cercle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            ArrayList<Point> sommet = new ArrayList<Point>();
           for(int i =0; i<5;i++){
               sommet.add(new Point(Math.random() * 200, Math.random() * 200));
           }
            this.figuresScene.add(new Polygone(sommet,"polygone",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));

            this.figuresScene.add(new Rectangle(new Point(Math.random() * 400, Math.random() * 400),100,300,"Rectangle",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            
            ArrayList<Point> sommet2 = new ArrayList<Point>();
           for(int i =0; i<5;i++){
               sommet2.add(new Point(Math.random() * 200, Math.random() * 200));
           }
            this.figuresScene.add(new Polyligne(sommet2,"polygone",
                        new Color(
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)),
                                ((int) (Math.random() * 255)))));
            
       
    }
   
}
