/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import utils.Lire;

/**
 *
 * @author Nicolas
 */
public class Rectangle extends Polygone{
    
 
    // Constructeur

    public Rectangle(Point p1, double largeur, double longueur, String nom, Color couleur) {
        super(new ArrayList<Point>(), nom, couleur);
        this.getSommet().add(new Point (p1.getCoordx() + longueur,p1.getCoordy()));
        this.getSommet().add(new Point (p1.getCoordx() + longueur,p1.getCoordy() + largeur));
        this.getSommet().add(new Point (p1.getCoordx(),p1.getCoordy() + largeur));
    }
  
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.drawRect((int)this.getSommet().get(0).getCoordx(),(int)this.getSommet().get(0).getCoordy(),15,20);
    }
  

}
