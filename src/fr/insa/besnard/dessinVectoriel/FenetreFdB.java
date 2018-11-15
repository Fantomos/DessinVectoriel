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
public class FenetreFdB extends JPanel {

    private SceneDessin sceneDessin;
    private MenuPanel menu;

    public FenetreFdB(SceneDessin sceneDessin, MenuPanel menu) {
        this.sceneDessin = sceneDessin;
        this.menu = menu;
        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.NORTH);
        this.add(sceneDessin, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame finale = new JFrame();
        finale.setSize(1000, 600);
        finale.add(new FenetreFdB(SceneDessin.sceneTest(10), new MenuPanel()));
        finale.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        finale.setVisible(true);

    }

}
