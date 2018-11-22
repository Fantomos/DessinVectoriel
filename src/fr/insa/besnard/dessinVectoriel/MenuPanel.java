/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

/**
 *
 * @author nbesnard01
 */
public class MenuPanel extends JPanel implements ActionListener{
    private JToggleButton jbPoint;
    private JToggleButton jbSegment;
    private JToggleButton jbEllipse;
     private JToggleButton jbCercle;
    private JToggleButton jbRectangle;
    private JToggleButton jbPolygone;
 
     
      private JToggleButton jbSelection;
     private Container outils;
     private Container figures;
   
    private ScenePrincipal main;
    
    public JToggleButton getJbRectangle() {
        return jbRectangle;
    }

    public JToggleButton getJbPolygone() {
        return jbPolygone;
    }

    public void setJbRectangle(JToggleButton jbRectangle) {
        this.jbRectangle = jbRectangle;
    }

    public JToggleButton getJbCercle() {
        return jbCercle;
    }
    

    public JToggleButton getJbPoint() {
        return jbPoint;
    }

    public void setJbPoint(JToggleButton jbPoint) {
        this.jbPoint = jbPoint;
    }

    public JToggleButton getJbSegment() {
        return jbSegment;
    }

    public void setJbSegment(JToggleButton jbSegment) {
        this.jbSegment = jbSegment;
    }

    public JToggleButton getJbEllipse() {
        return jbEllipse;
    }

    public void setJbEllipse(JToggleButton jbEllipse) {
        this.jbEllipse = jbEllipse;
    }
    
    
    public MenuPanel(ScenePrincipal main){
        this.jbPoint = new JToggleButton("Point");
        this.jbSegment = new JToggleButton("Segment");
        this.jbEllipse = new JToggleButton("Ellipse");
        this.jbCercle = new JToggleButton("Cercle");
        this.jbRectangle = new JToggleButton("Rectangle");
         this.jbPolygone = new JToggleButton("Polygone");
         this.jbSelection = new JToggleButton("Selection");
         this.figures = new Container();
         this.outils = new Container();
        this.main = main;
        this.jbPoint.addActionListener(this);
        this.jbSegment.addActionListener(this);
         this.jbEllipse.addActionListener(this);
         this.jbCercle.addActionListener(this);
         this.jbRectangle.addActionListener(this);
          this.jbRectangle.addActionListener(this);
          this.jbSelection.addActionListener(this);
         
          
        
        outils.setLayout(new GridLayout(1,5));
        outils.add(jbSelection);
        
       
        figures.setLayout(new GridLayout(1,6));
        figures.add(jbPoint);
        figures.add(jbSegment);
        figures.add(jbEllipse);
        figures.add(jbCercle);
        figures.add(jbRectangle);
        figures.add(jbPolygone);
        
        this.setLayout(new GridLayout(2,1));
       
        ButtonGroup boutons = new ButtonGroup();
        boutons.add(jbPoint);
        boutons.add(jbSegment);
        boutons.add(jbEllipse);
          boutons.add(jbCercle);
        boutons.add(jbRectangle);
        boutons.add(jbPolygone);
        boutons.add(jbSelection);
        
       
        this.add(outils);
         this.add(figures);
    }
    
    
    
    
    public static void main(String[] args) {
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Annule toutes les constructions
        this.main.getSceneDessin().setConstructionSeg(false);
        this.main.getSceneDessin().setConstructionEllipse(false);
        this.main.getSceneDessin().setConstructionCercle(false);
        this.main.getSceneDessin().setConstructionRec(false);
        this.main.getSceneDessin().setConstructionPoly(false);
        this.main.getSceneDessin().repaint();
        
        
        // Gere l'affichage du texte
        if (e.getSource() == jbPoint) {
            if (jbPoint.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un point");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }
       
        }
        else if (e.getSource() == jbSegment) {
            if (jbSegment.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un segment");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbEllipse) {
            if (jbEllipse.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter une ellipse");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbCercle) {
            if (jbCercle.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un cercle");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbRectangle) {
            if (jbRectangle.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un rectangle");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbPolygone) {
            if (jbPolygone.isSelected()) {
                this.main.getInfo().getInfoText().setText("Clique droit pour ajouter des sommets. Clique gauche pour valider");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
         
    
    }

    
}
