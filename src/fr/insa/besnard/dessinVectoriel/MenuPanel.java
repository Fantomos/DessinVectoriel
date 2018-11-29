/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

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
     private JToggleButton jbCarre;
    private JToggleButton jbPolygone;
     private JToggleButton jbPolyligne;
 
      private JToggleButton jbSelection;
      private JToggleButton jbSupprimer;
      private JToggleButton jbCreeEnsemble;
      private JButton jbNouveau;
      private JButton jbOuvrir;
      private JButton jbSave;
     private Container listeBoutons;
  
   
    private ScenePrincipal main;

    public JToggleButton getJbCarre() {
        return jbCarre;
    }

    public JToggleButton getJbSelection() {
        return jbSelection;
    }

    public JToggleButton getJbSupprimer() {
        return jbSupprimer;
    }
    
    public JToggleButton getJbRectangle() {
        return jbRectangle;
    }

    public JToggleButton getJbPolyligne() {
        return jbPolyligne;
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
        this.jbPoint = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/point.png"));
        this.jbSegment = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/segment.png"));
        this.jbEllipse = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/ellipse.png"));
        this.jbCercle = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/cercle.png"));
        this.jbRectangle = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/rectangle.png"));
         this.jbCarre = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/carre.png"));
         this.jbPolygone = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/polygone.png"));
          this.jbPolyligne = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/polyligne.png"));
         this.jbSelection = new JToggleButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/selectionner2.png"));
         this.jbCreeEnsemble = new JToggleButton("Creer ef");
         this.jbSupprimer = new JToggleButton("Supp");
         
          this.jbNouveau = new JButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/nouveau.png"));
          this.jbOuvrir = new JButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/ouvrir.png"));
         this.jbSave = new JButton(new ImageIcon("src/fr/insa/besnard/dessinVectoriel/Images/save.png"));
         this.listeBoutons = new Container();
      
         this.jbPoint.setToolTipText("Point");
        this.jbSegment.setToolTipText("Segment");
         this.jbEllipse.setToolTipText("Ellipse");
         this.jbCercle.setToolTipText("Cercle");
         this.jbRectangle.setToolTipText("Rectangle");
          this.jbCarre.setToolTipText("Carre");
          this.jbPolygone.setToolTipText("Polygone");
          this.jbPolyligne.setToolTipText("Polyligne");
          this.jbSelection.setToolTipText("Selection");
           this.jbCreeEnsemble.setToolTipText("Ensemble");
          this.jbSupprimer.setToolTipText("Supprimer");
           this.jbNouveau.setToolTipText("Nouveau");
          this.jbOuvrir.setToolTipText("Ouvrir");
        this.jbSave.setToolTipText("Sauvegarder");
       
       



         
        this.main = main;
        this.jbPoint.addActionListener(this);
        this.jbSegment.addActionListener(this);
         this.jbEllipse.addActionListener(this);
         this.jbCercle.addActionListener(this);
         this.jbRectangle.addActionListener(this);
          this.jbCarre.addActionListener(this);
          this.jbPolygone.addActionListener(this);
          this.jbPolyligne.addActionListener(this);
          this.jbSelection.addActionListener(this);
          this.jbCreeEnsemble.addActionListener(this);
          this.jbSupprimer.addActionListener(this);
           this.jbNouveau.addActionListener(this);
          this.jbOuvrir.addActionListener(this);
        this.jbSave.addActionListener(this);
              
         
         
       
        ButtonGroup boutons = new ButtonGroup();
        boutons.add(jbPoint);
        boutons.add(jbSegment);
        boutons.add(jbEllipse);
          boutons.add(jbCercle);
        boutons.add(jbRectangle);
         boutons.add(jbCarre);
        boutons.add(jbPolygone);
        boutons.add(jbPolyligne);
        boutons.add(jbSelection);
        boutons.add(jbCreeEnsemble);
         boutons.add(jbSupprimer);
       
        
       
    
        listeBoutons.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
         c.gridy = 2;
         c.fill = GridBagConstraints.BOTH;
        listeBoutons.add(jbPoint,c);
         
        c.gridx = 1;
          c.gridy = 2;  
        listeBoutons.add(jbSegment,c);
          
        c.gridx = 2;
           c.gridy = 2;
         listeBoutons.add(jbPolyligne,c);
       
         c.gridx = 3;
          c.gridy = 2;
        listeBoutons.add(jbPolygone,c);
       
        c.gridx = 4;
           c.gridy = 2;
         listeBoutons.add(jbRectangle,c);
         
         c.gridx = 5;
            c.gridy = 2;
          listeBoutons.add(jbCarre,c);
          
          c.gridx = 6;
           c.gridy = 2;
        listeBoutons.add(jbEllipse,c);
           
        c.gridx = 7;
           c.gridy = 2;
           
         listeBoutons.add(jbCercle,c);
           
         c.gridx = 0;
         c.gridy = 1;
         listeBoutons.add(jbSelection,c);
         
         c.gridx = 1;
         c.gridy = 1;
         listeBoutons.add(jbCreeEnsemble,c);
         
         c.gridx = 2;
         c.gridy = 1;
         listeBoutons.add(jbSupprimer,c);
         
         
          c.gridx = 0;
         c.gridy = 0;
         
         listeBoutons.add(jbNouveau,c);
         
         c.gridx = 1;
         c.gridy = 0;
         listeBoutons.add(jbOuvrir,c);
         
         c.gridx = 2;
         c.gridy = 0;
         listeBoutons.add(jbSave,c);
           this.setBackground(Color.LIGHT_GRAY);
          this.setLayout(new FlowLayout(FlowLayout.LEFT));
          this.add(listeBoutons);
       
    }
    
    
    
    
    public static void main(String[] args) {
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Annule toutes les constructions/selections
        this.main.getSceneDessin().setConstructionSeg(false);
        this.main.getSceneDessin().setConstructionEllipse(false);
        this.main.getSceneDessin().setConstructionCercle(false);
        this.main.getSceneDessin().setConstructionRec(false);
         this.main.getSceneDessin().setConstructionCarre(false);
        this.main.getSceneDessin().setConstructionPoly(false);
        this.main.getSceneDessin().setConstructionPolyligne(false);
        this.main.getSceneDessin().setEnSelection(false);
        this.main.getSceneDessin().repaint();
        
        
        // Gere l'affichage du texte
        if (e.getSource() == jbPoint) {
            if (jbPoint.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un point");
                this.main.getDetail().afficherDetail(new Point());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }
       
        }
        else if (e.getSource() == jbSegment) {
            if (jbSegment.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un segment");
                this.main.getDetail().afficherDetail(new Segment());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbEllipse) {
            if (jbEllipse.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter une ellipse");
                 this.main.getDetail().afficherDetail(new Ellipse());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbCercle) {
            if (jbCercle.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un cercle");
                 this.main.getDetail().afficherDetail(new Cercle());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbRectangle) {
            if (jbRectangle.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un rectangle");
                 this.main.getDetail().afficherDetail(new Rectangle());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
          else if (e.getSource() == jbCarre) {
            if (jbCarre.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un carre");
                this.main.getDetail().afficherDetail(new Carre());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        else if (e.getSource() == jbPolygone) {
            if (jbPolygone.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un polygone");
                 this.main.getDetail().afficherDetail(new Polygone());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
         else if (e.getSource() == jbPolyligne) {
            if (jbPolyligne.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un polyligne");
                this.main.getDetail().afficherDetail(new Polyligne());
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
         else if(e.getSource() == jbSelection){
               if (jbSelection.isSelected()) {
                this.main.getInfo().getInfoText().setText("Selectionner une figure pour la modifier");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }
         }
          else if(e.getSource() == jbCreeEnsemble){
               if (jbSelection.isSelected()) {
                this.main.getInfo().getInfoText().setText("Selectionner une figure pour la modifier");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }
         }
          
        else if(e.getSource() == jbSupprimer){
             this.main.getDetail().setVisible(false);
               if (jbSupprimer.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer sur une figure pour la supprimer");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }
         }
         
    
    }

    
}
