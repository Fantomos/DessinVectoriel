/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author nbesnard01
 */
public class MenuPanel extends JPanel{
    private JButton jbPoint;
    private JButton jbSegment;
    private JButton jbCercle;
    
    public MenuPanel(){
        this.jbPoint = new JButton("P");
        this.jbSegment = new JButton("S");
         this.jbCercle = new JButton("C");
        this.setLayout(new GridLayout(1,3));
        this.add(jbPoint);
        this.add(jbSegment);
         this.add(jbCercle);
  
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame("test point");
        f.setSize(100, 50);
        // l'instruction ci-dessous indique que l'on veut
        // arréter l'application lorsque l'on ferme la fenetre
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(new MenuPanel());
        f.setVisible(true);
    }
    
}
