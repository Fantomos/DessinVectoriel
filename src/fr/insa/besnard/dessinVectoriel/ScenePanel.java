/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Nicolas
 */
public class ScenePanel extends JPanel
        implements MouseListener {

    private SceneDessin laScene;

    public ScenePanel(SceneDessin laScene) {
        this.laScene = laScene;
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < this.laScene.getfiguresScene().size(); i++) {
            Figure cur = this.laScene.getfiguresScene().get(i);
            cur.dessine(g);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("test point");
        f.setSize(600, 400);
        // l'instruction ci-dessous indique que l'on veut
        // arréter l'application lorsque l'on ferme la fenetre
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SceneDessin s = SceneDessin.sceneTest(20);
        ScenePanel sp = new ScenePanel(s);
        f.add(sp);
        f.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // todo
        
        System.out.println(this.laScene.getfiguresScene().get(4).distancePoint(new Point(e.getX(),e.getY())));
    
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
