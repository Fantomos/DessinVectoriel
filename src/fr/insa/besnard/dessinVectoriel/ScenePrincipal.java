/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author nbesnard01
 */
public class ScenePrincipal extends JPanel implements MouseListener{

    private SceneDessin sceneDessin;
    private MenuPanel menu;


    public ScenePrincipal(SceneDessin sceneDessin,MenuPanel menu) {
        this.sceneDessin = sceneDessin;
        this.menu = menu;
        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.NORTH);
        this.add(sceneDessin, BorderLayout.CENTER);
        this.addMouseListener(this);
    }
    
  

    public static void main(String[] args) {
        JFrame finale = new JFrame();
        finale.setSize(1000, 600);
        finale.add(new ScenePrincipal(SceneDessin.sceneTest(10),new MenuPanel()));
        finale.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        finale.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource());
        if(menu.getJbPoint().isSelected())
        {
            
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

}