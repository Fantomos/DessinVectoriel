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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nicolas
 */
public class SceneDessin extends JPanel implements MouseListener, MouseMotionListener {

    private ScenePrincipal main;
    private ArrayList<Figure> figuresScene;
    private boolean constructionSeg;
    private boolean constructionEllipse;
    private boolean constructionCercle;
    private boolean constructionRec;
    private boolean constructionCarre;
    private boolean constructionPoly;
    private boolean constructionPolyligne;
    private boolean constructionEnsemble;
    private boolean enSelection;
    private Segment stTemp;
    private Ellipse elTemp;
    private Cercle clTemp;
    private Rectangle recTemp;
    private Carre carTemp;
    private Polyligne plTemp;
    private Polygone plgTemp;
    private Figure fgContourBleu;
    private Figure fgSelected;
    private int fgSelectedIndexPoint;
    private EnsembleFigures efTemp;
   

    public void setEnSelection(boolean enSelection) {
        this.enSelection = enSelection;
    }

    public void setFgContourBleu(Figure fgContourBleu) {
        this.fgContourBleu = fgContourBleu;
    }

    public boolean isEnSelection() {
        return enSelection;
    }

    public boolean isConstructionEnsemble() {
        return constructionEnsemble;
    }

    public void setConstructionCarre(boolean constructionCarre) {
        this.constructionCarre = constructionCarre;
    }

    public void setConstructionEllipse(boolean constructionEllipse) {
        this.constructionEllipse = constructionEllipse;
    }

    public void setConstructionCercle(boolean constructionCercle) {
        this.constructionCercle = constructionCercle;
    }

    public void setConstructionSeg(boolean constructionSeg) {
        this.constructionSeg = constructionSeg;
    }

    public void setConstructionEnsemble(boolean constructionEnsemble) {
        this.constructionEnsemble = constructionEnsemble;
    }

    public void setConstructionRec(boolean constructionRec) {
        this.constructionRec = constructionRec;
    }

    public void setConstructionPoly(boolean constructionPoly) {
        this.constructionPoly = constructionPoly;
    }

    public void setConstructionPolyligne(boolean constructionPolyligne) {
        this.constructionPolyligne = constructionPolyligne;
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
        this.constructionCarre = false;
        this.constructionSeg = false;
        this.constructionPoly = false;
        this.constructionPolyligne = false;
        this.enSelection = false;

    }

    public void eclaterEnsemble(EnsembleFigures ef) {
        this.figuresScene.addAll(ef.getTabFigures());
        this.figuresScene.remove(ef);
    }
    
    public void creerEnsemble(EnsembleFigures ef){
       this.figuresScene.add(ef);
       this.figuresScene.removeAll(ef.getTabFigures());
    }

    public Figure figureProche(Point clic){
        if(figuresScene.isEmpty()){
            return null;
        }
         Figure figure =  Collections.min(this.figuresScene, Comparator.comparing((Figure a) -> a.distancePoint(clic)));
         if(figure.distancePoint(clic) < 50){
                return figure;
         }
         return null;
               
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
        if (this.constructionSeg == true) {
            this.stTemp.dessine(g);
        }
        if (this.constructionEllipse == true) {
            this.elTemp.dessine(g);
        }
        if (this.constructionCercle == true) {
            this.clTemp.dessine(g);
        }
        if (this.constructionRec == true) {
            this.recTemp.dessine(g);
        }
        if (this.constructionCarre == true) {
            this.carTemp.dessine(g);
        }
        if (this.constructionPoly == true) {
            this.plgTemp.dessine(g);
        }
        if (this.constructionPolyligne == true) {
            this.plTemp.dessine(g);
        }
        if(this.constructionEnsemble == true){
            this.fgContourBleu.dessine(g);
        }
        
        
        //Dessine la selection
        if(this.enSelection == true){
            this.fgContourBleu.dessine(g);
            
            //Dessine le point selectionné sur la selection
            if(this.fgSelectedIndexPoint != -1){
                if(fgSelected instanceof Polygone){
                    
                    ((Polygone) fgSelected).getSommet().get(fgSelectedIndexPoint).setCouleur(Color.blue);
                    ((Polygone) fgSelected).getSommet().get(fgSelectedIndexPoint).dessine(g);
                }
                else if(fgSelected instanceof Polyligne){
                    ((Polyligne) fgSelected).getSommet().get(fgSelectedIndexPoint).setCouleur(Color.blue);
                    ((Polyligne) fgSelected).getSommet().get(fgSelectedIndexPoint).dessine(g);
                } 
                else if(fgSelected.getClass().equals(Segment.class)){
                    if(this.fgSelectedIndexPoint == 0){
                        ((Segment) fgSelected).getDepart().setCouleur(Color.blue);
                    ((Segment) fgSelected).getDepart().dessine(g);
                    }
                    else{
                        ((Segment) fgSelected).getFin().setCouleur(Color.blue);
                    ((Segment) fgSelected).getFin().dessine(g);
                    }
                    
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.enSelection = false;
        
        // Si Bouton Point selectionné
        if (main.getMenu().getJbPoint().isSelected()) {
            Point a = (Point)this.main.getDetail().getFigureDetail().copy();
            a.setCoordx(e.getX());
            a.setCoordy(e.getY());
            this.getfiguresScene().add(a);
            this.repaint();
        } // Si Bouton Segment selectionné
        else if (main.getMenu().getJbSegment().isSelected()) {
            // Si premier clique
            if (this.constructionSeg == false) {
                this.stTemp = (Segment)this.main.getDetail().getFigureDetail().copy();
                stTemp.setDepart(new Point(e.getX(),e.getY()));
                this.constructionSeg = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");

            } // Si construction en cours
            else {
                this.figuresScene.add(this.stTemp);
                this.constructionSeg = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un segment");
            }

        } // Si Bouton Ellipse selectionné
        else if (main.getMenu().getJbEllipse().isSelected()) {

            if (this.constructionEllipse == false) {
                this.elTemp = (Ellipse)this.main.getDetail().getFigureDetail().copy();
                this.elTemp.setCenter(new Point(e.getX(), e.getY()));
                this.constructionEllipse = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
            } // Si construction en cours
            else {
                this.figuresScene.add(this.elTemp);
                this.constructionEllipse = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter une ellipse");
            }
        } // Si Bouton Cercle selectionné
        else if (main.getMenu().getJbCercle().isSelected()) {

            if (this.constructionCercle == false) {
                this.clTemp = (Cercle)this.main.getDetail().getFigureDetail().copy();
                this.clTemp.setCenter(new Point(e.getX(), e.getY()));
                this.constructionCercle = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
            } // Si construction en cours
            else {
                this.figuresScene.add(this.clTemp);
                this.constructionCercle = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un cercle");
            }
        } // Si Bouton Rectangle selectionné
        else if (main.getMenu().getJbRectangle().isSelected()) {

            if (this.constructionRec == false) {
                this.recTemp = (Rectangle)this.main.getDetail().getFigureDetail();
                this.recTemp.update(new Point(e.getX(), e.getY()),0,0);
                this.constructionRec = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
                this.main.getDetail().afficherDetail(new Rectangle());

            } // Si construction en cours
            else {
                this.figuresScene.add(this.recTemp);
                this.constructionRec = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un rectangle");
                
            }
            
        }
         // Si Bouton Carre selectionné
        else if (main.getMenu().getJbCarre().isSelected()) {

            if (this.constructionCarre == false) {
                this.carTemp = (Carre)this.main.getDetail().getFigureDetail();
                this.carTemp.update(new Point(e.getX(), e.getY()),0);
                this.constructionCarre = true;
                this.main.getInfo().getInfoText().setText("Cliquer pour valider");
                this.main.getDetail().afficherDetail(new Carre());
            } // Si construction en cours
            else {
                this.figuresScene.add(this.carTemp);
                this.constructionCarre = false;
                this.repaint();
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un carre");
            }
            
        }// Si Bouton Polygone selectionné
        else if (main.getMenu().getJbPolygone().isSelected()) {

            if (this.constructionPoly == false) {
                this.plgTemp = (Polygone)this.main.getDetail().getFigureDetail();
                plgTemp.getSommet().add(new Point(e.getX(), e.getY()));
                this.constructionPoly = true;
                this.main.getInfo().getInfoText().setText("Clique gauche pour ajouter des sommets. Clique droit pour valider");
                this.repaint();
            } // Si construction en cours
            else {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if(this.plgTemp.getSommet().size() > 1){
                     this.plgTemp.getSommet().remove(this.plgTemp.getSommet().size()-1);
                    }
                    if (plgTemp.getSommet().size() > 2) {
                        this.figuresScene.add(this.plgTemp);
                        this.main.getDetail().afficherDetail(new Polygone());
                    }
                    this.constructionPoly = false;
                    this.repaint();
                    this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un polygone");
                } else {
                    this.plgTemp.getSommet().add(new Point(e.getX(), e.getY()));
                    this.repaint();
                }

            }
        } // Si Bouton Polyligne selectionné
        else if (main.getMenu().getJbPolyligne().isSelected()) {

            if (this.constructionPolyligne == false) {
                this.plTemp = (Polyligne)this.main.getDetail().getFigureDetail();
                plTemp.getSommet().add(new Point(e.getX(), e.getY()));
                this.constructionPolyligne = true;
                this.main.getInfo().getInfoText().setText("Clique gauche pour ajouter des sommets. Clique droit pour valider");
                this.repaint();
            } // Si construction en cours
            else {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if(this.plTemp.getSommet().size() > 1){
                     this.plTemp.getSommet().remove(this.plTemp.getSommet().size()-1);
                    }
                    if (plTemp.getSommet().size() > 2) {
                        this.figuresScene.add(plTemp);
                        this.main.getDetail().afficherDetail(new Polyligne());
                    }
                    this.constructionPolyligne = false;
                    this.repaint();
                    this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un polyligne");
                } else {
                    this.plTemp.getSommet().add(new Point(e.getX(), e.getY()));
                    this.repaint();
                }

            }
        } // Si Bouton Selection en cours
        else if (main.getMenu().getJbSelection().isSelected()) {
                
                this.fgSelected = this.figureProche(new Point(e.getX(), e.getY()));
            
                // Si figure est assez proche
                if(fgSelected != null){   
                enSelection = true;
                fgSelectedIndexPoint = -1;
                
                // Cas des figures déformable
                if(fgSelected instanceof Segment){
                    Segment sgSelected = (Segment) fgSelected;
                    this.fgSelectedIndexPoint = sgSelected.extremiteProche(new Point(e.getX(), e.getY())); 
                    main.getInfo().getInfoText().setText("Clique sur un coin pour changer la taille / Clique sur un coté pour le déplacer");
                }
                else if(fgSelected instanceof Polygone){
                    Polygone polySelected = (Polygone) fgSelected;
                    this.fgSelectedIndexPoint = polySelected.sommetProche(new Point(e.getX(), e.getY())); 
                    main.getInfo().getInfoText().setText("Clique sur un coin pour changer la taille / Clique sur un coté pour le déplacer");
                }
                else if(fgSelected instanceof Polyligne){
                    Polyligne polySelected = (Polyligne) fgSelected;
                    this.fgSelectedIndexPoint = polySelected.sommetProche(new Point(e.getX(), e.getY())); 
                    main.getInfo().getInfoText().setText("Clique sur un coin pour changer la taille / Clique sur un coté pour le déplacer");
                }
                 
                 
               
          
                this.main.getDetail().afficherDetail(fgSelected);
                
                } // Sinon si aucune figure proche
                else{
                     enSelection=false;
                     this.main.getDetail().setVisible(false);
                }
            
        }
        else if(main.getMenu().getJbSupprimer().isSelected()) {
            Figure figSup =  this.figureProche(new Point(e.getX(), e.getY()));
            this.figuresScene.remove(figSup);
            this.repaint();
        }
        else if (main.getMenu().getJbCreeEnsemble().isSelected()) {
           
            if (this.constructionEnsemble == false) {
                 if (!SwingUtilities.isRightMouseButton(e)) {
              
                 Figure figSup = this.figureProche(new Point(e.getX(), e.getY()));
                 if(figSup != null){
                        constructionEnsemble = true;
                        efTemp = new EnsembleFigures(new ArrayList<Figure>());
                        efTemp.ajouterFigure(figSup);
                         main.getDetail().afficherDetail(efTemp);
                 }
                 }

            } else {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (!efTemp.getTabFigures().isEmpty()) {
                        creerEnsemble(efTemp);
                         constructionEnsemble = false;
                        efTemp.afficheFigure();
                    }
                }
                else{
                     Figure figSup = this.figureProche(new Point(e.getX(), e.getY()));
                    if(figSup != null && efTemp.getTabFigures().indexOf(figSup) == -1){
                     efTemp.ajouterFigure(figSup);
                      main.getDetail().afficherDetail(efTemp);
                      
                    }
                }
            }

          
            
            
            this.repaint();
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
        
            // Deplace les figures
        if (enSelection) {

            if (fgSelected instanceof Segment) {
                Segment sgSelected = ((Segment) fgSelected);
                // Deplace les sommets
                if (this.fgSelectedIndexPoint == 0) {
                    sgSelected.setDepart(new Point(e.getX(), e.getY()));
                } else if (this.fgSelectedIndexPoint == 1) {
                    sgSelected.setFin(new Point(e.getX(), e.getY()));
                } // Deplace le segment entier
                else {
                    sgSelected.deplace(e);
                }

            } else if (fgSelected.getClass().equals(Polygone.class)) {
                Polygone polySelected = ((Polygone) fgSelected);
                // Deplace les sommets
                if (this.fgSelectedIndexPoint != -1) {
                    polySelected.getSommet().set(fgSelectedIndexPoint, new Point(e.getX(), e.getY()));
                } // Deplace le polygone entier
                else {
                    polySelected.deplace(e);

                }
            } else if (fgSelected.getClass().equals(Rectangle.class)) {
                Rectangle recSelected = ((Rectangle) fgSelected);
                // Redimensionne largeur/longueur
                if (this.fgSelectedIndexPoint != -1) {
                    recSelected.update(e.getY() - recSelected.getSommet().get(0).getCoordy(), e.getX() - recSelected.getSommet().get(0).getCoordx());

                } // Deplace le rectangle entier
                else {
                    recSelected.deplace(e);
                }

            } else if (fgSelected.getClass().equals(Carre.class)) {
                Carre carSelected = ((Carre) fgSelected);
                // Redimensionne longueur
                if (this.fgSelectedIndexPoint != -1) {
                    carSelected.update(carSelected.getSommet().get(0), Math.max(e.getY() - carSelected.getSommet().get(0).getCoordy(), e.getX() - carSelected.getSommet().get(0).getCoordx()));

                } // Deplace le carre entier
                else {
                    carSelected.deplace(e);
                }

            } else if (fgSelected.getClass().equals(Polyligne.class)) {
                Polyligne polySelected = (Polyligne) fgSelected;
                // Deplace les sommets
                if (this.fgSelectedIndexPoint != -1) {
                    polySelected.getSommet().set(fgSelectedIndexPoint, new Point(e.getX(), e.getY()));
                } // Deplace la polyligne entiere
                else {
                    polySelected.deplace(e);

                }
            } else if (fgSelected.getClass().equals(EnsembleFigures.class)) {
                EnsembleFigures ef = (EnsembleFigures) fgSelected;
                for (int i = 0; i < ef.getTabFigures().size(); i++) {
                    ef.deplace(e);
                }

            } else {
                fgSelected.deplace(e);
            }

            this.main.getDetail().afficherDetail(fgSelected);
        }
    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        // Construction dynamique des figures
        if (this.constructionSeg == true) {
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.stTemp.setFin(new Point(p.x, p.y));
            this.repaint();
        } else if (this.constructionEllipse == true) {
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.elTemp.setRayonX(Math.abs(p.x - this.elTemp.getCenter().getCoordx()));
            this.elTemp.setRayonY(Math.abs(p.y - this.elTemp.getCenter().getCoordy()));
            this.repaint();
        } else if (this.constructionCercle == true) {
            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);

            this.clTemp.update(Math.max(p.y - this.clTemp.getCenter().getCoordy(), p.x - this.clTemp.getCenter().getCoordx()));

            this.repaint();
        } else if (this.constructionRec == true) {

            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.recTemp.update(recTemp.getSommet().get(0),p.y - recTemp.getSommet().get(0).getCoordy(), p.x - recTemp.getSommet().get(0).getCoordx());

            this.repaint();
        }
        else if (this.constructionCarre == true) {

            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            this.carTemp.update(carTemp.getSommet().get(0),Math.max(p.y - carTemp.getSommet().get(0).getCoordy(), p.x - carTemp.getSommet().get(0).getCoordx()));
            this.repaint();
        }
        else if (this.constructionPolyligne == true) {

            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            Point p1 = new Point(p.x,p.y);
            if(this.plTemp.getSommet().size() > 1){
                this.plTemp.getSommet().remove(this.plTemp.getSommet().size()-1);
            }
            this.plTemp.getSommet().add(p1);
            this.repaint();
        }
         else if (this.constructionPoly == true) {

            java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, this);
            Point p1 = new Point(p.x,p.y);
            if(this.plgTemp.getSommet().size() > 1){
                this.plgTemp.getSommet().remove(this.plgTemp.getSommet().size()-1);
            }
            this.plgTemp.getSommet().add(p1);
            this.repaint();
        }

    }

    public void sceneTest(int nbr) {

        this.figuresScene.add(
                new Point(
                        Math.random() * 400,
                        Math.random() * 400, "point", new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));
        this.figuresScene.add(new Segment(new Point(Math.random() * 400, Math.random() * 400), new Point(Math.random() * 400, Math.random() * 400), "segment",
                new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));

        this.figuresScene.add(new Cercle(new Point(Math.random() * 400, Math.random() * 400), Math.random() * 100, "cercle",
                new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));
        this.figuresScene.add(new Ellipse(new Point(Math.random() * 400, Math.random() * 400), Math.random() * 100, Math.random() * 100, "cercle",
                new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));
        ArrayList<Point> sommet = new ArrayList<Point>();
        for (int i = 0; i < 5; i++) {
            sommet.add(new Point(Math.random() * 200, Math.random() * 200));
        }
        this.figuresScene.add(new Polygone(sommet, "polygone",
                new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));

        this.figuresScene.add(new Rectangle(new Point(Math.random() * 400, Math.random() * 400), 100, 300, "Rectangle",
                new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));

        ArrayList<Point> sommet2 = new ArrayList<Point>();
        for (int i = 0; i < 5; i++) {
            sommet2.add(new Point(Math.random() * 200, Math.random() * 200));
        }
        this.figuresScene.add(new Polyligne(sommet2, "polygone",
                new Color(
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)),
                        ((int) (Math.random() * 255)))));

    }

}
