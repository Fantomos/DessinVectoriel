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
    private ScenePrincipal main;

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
        this.main = main;
        this.jbPoint.addActionListener(this);
        this.jbSegment.addActionListener(this);
         this.jbEllipse.addActionListener(this);
        this.setLayout(new GridLayout(1,3));
        ButtonGroup boutons = new ButtonGroup();
        boutons.add(jbPoint);
        boutons.add(jbSegment);
        boutons.add(jbEllipse);
        this.add(jbPoint);
        this.add(jbSegment);
        this.add(jbEllipse);
    }
    
    
    
    
    public static void main(String[] args) {
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbPoint) {
            if (jbPoint.isSelected()) {
                this.main.getSceneDessin().setConstructionSeg(false);
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter un point");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }
       
        }
        if (e.getSource() == jbSegment) {
            if (jbSegment.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter la première extremité du segment");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
        if (e.getSource() == jbEllipse) {
            if (jbEllipse.isSelected()) {
                this.main.getInfo().getInfoText().setText("Cliquer pour ajouter le centre de l'ellipse");
            } else {
                this.main.getInfo().getInfoText().setText("Ajouter des figures");
            }

        }
    }

    
}
