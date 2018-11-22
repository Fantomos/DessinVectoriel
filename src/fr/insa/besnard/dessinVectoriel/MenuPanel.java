/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

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
    private JToggleButton jbRectangle;
    private ScenePrincipal main;
    
    public JToggleButton getJbRectangle() {
        return jbRectangle;
    }

    public void setJbRectangle(JToggleButton jbRectangle) {
        this.jbRectangle = jbRectangle;
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
        this.jbPoint = new JToggleButton("P");
        this.jbSegment = new JToggleButton("S");
        this.jbEllipse = new JToggleButton("E");
        this.jbRectangle = new JToggleButton("R");
        this.main = main;
        this.jbPoint.addActionListener(this);
        this.jbSegment.addActionListener(this);
         this.jbEllipse.addActionListener(this);
         this.jbRectangle.addActionListener(this);
        this.setLayout(new GridLayout(1,3));
        ButtonGroup boutons = new ButtonGroup();
        boutons.add(jbPoint);
        boutons.add(jbSegment);
        boutons.add(jbEllipse);
        boutons.add(jbRectangle);
        this.add(jbPoint);
        this.add(jbSegment);
        this.add(jbEllipse);
        this.add(jbRectangle);
    }
    
    
    
    
    public static void main(String[] args) {
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Annule toutes les constructions
        this.main.getSceneDessin().setConstructionSeg(false);
        this.main.getSceneDessin().setConstructionEllipse(false);
          this.main.getSceneDessin().setConstructionRec(false);
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
        else if (e.getSource() == jbRectangle) {
            if (jbRectangle.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un rectangle");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
    }

    
}
