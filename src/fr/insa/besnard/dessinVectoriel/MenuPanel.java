/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

/**
 *
 * @author nbesnard01
 */
public class MenuPanel extends JPanel{
    private JToggleButton jbPoint;
    private JToggleButton jbSegment;
    private JToggleButton jbCercle;

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

    public JToggleButton getJbCercle() {
        return jbCercle;
    }

    public void setJbCercle(JToggleButton jbCercle) {
        this.jbCercle = jbCercle;
    }
    
    
    public MenuPanel(){
        this.jbPoint = new JToggleButton("P");
        this.jbSegment = new JToggleButton("S");
        this.jbCercle = new JToggleButton("C");
        this.setLayout(new GridLayout(1,3));
        ButtonGroup boutons = new ButtonGroup();
        boutons.add(jbPoint);
        boutons.add(jbSegment);
        boutons.add(jbCercle);
        this.add(jbPoint);
        this.add(jbSegment);
        this.add(jbCercle);
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame("test point");
        f.setSize(300, 100);
        // l'instruction ci-dessous indique que l'on veut
        // arréter l'application lorsque l'on ferme la fenetre
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(new MenuPanel());
        f.setVisible(true);
    }
    
}
