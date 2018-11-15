/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author nbesnard01
 */
public class Fenetre extends JFrame{
    
    private SceneDessin sceneDessin;
    private MenuPanel menu;
    
    public Fenetre(SceneDessin sceneDessin, MenuPanel menu){
        this.sceneDessin = sceneDessin;
        this.menu = menu;
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(menu,BorderLayout.NORTH);
        this.add(sceneDessin,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
   public static void main(String[] args) {
        Fenetre f = new Fenetre(SceneDessin.sceneTest(10),new MenuPanel());
       
    }
    
    
}
