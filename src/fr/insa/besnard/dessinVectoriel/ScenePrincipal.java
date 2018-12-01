/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.BorderLayout;
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
    private DetailPanel detail;
    private InfoAction info;

    public void setSceneDessin(SceneDessin sceneDessin) {
        this.sceneDessin = sceneDessin;
    }

  

    public ScenePrincipal() {
        this.sceneDessin = new SceneDessin(this);
        this.menu = new MenuPanel(this);
        this.info = new InfoAction(this);
        this.detail = new DetailPanel(this);
        this.setLayout(new BorderLayout());
        this.add(this.menu, BorderLayout.NORTH);
        this.add(this.sceneDessin, BorderLayout.CENTER);
        this.add(this.info,BorderLayout.SOUTH);
        this.add(this.detail,BorderLayout.EAST);
        this.addMouseListener(this);
    }

    public DetailPanel getDetail() {
        return detail;
    }

    public MenuPanel getMenu() {
        return menu;
    }

    public InfoAction getInfo() {
        return info;
    }

      public SceneDessin getSceneDessin() {
        return sceneDessin;
    }
   
  

    public static void main(String[] args) {
        JFrame finale = new JFrame();
        finale.setSize(1000, 600);
        finale.add(new ScenePrincipal());
        finale.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        finale.setVisible(true);
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
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
