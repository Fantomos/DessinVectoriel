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

    public Rectangle(Point p1, double largeur, double longueur, String nom, Color couleur,boolean remplir) {
        super(new ArrayList<Point>(), nom, couleur,remplir);
        super.getSommet().add(p1);
        super.getSommet().add(new Point (p1.getCoordx() + longueur,p1.getCoordy()));
        super.getSommet().add(new Point (p1.getCoordx() + longueur,p1.getCoordy() + largeur));
        super.getSommet().add(new Point (p1.getCoordx(),p1.getCoordy() + largeur));
    }
     public Rectangle(Point p1, double largeur, double longueur,String nom, Color couleur) {
        this(p1,largeur,longueur,nom,couleur,false);
    }
    public Rectangle(Point p1, double largeur, double longueur) {
        this(p1,largeur,longueur,"Rectangle",Color.BLACK,false);
    }
    public Rectangle(Rectangle rec) {
       super(rec);
    }
     public Rectangle() {
        this(new Point(),0,0,"Rectangle",Color.BLACK,false);
    }
   
   public void update(Point p1,double largeur,double longueur){
      this.getSommet().set(0, p1);
      this.getSommet().get(1).setCoordx(p1.getCoordx() + longueur);
       this.getSommet().get(2).setCoordx(p1.getCoordx() + longueur);
       this.getSommet().get(2).setCoordy(p1.getCoordy() + largeur);
       this.getSommet().get(3).setCoordy(p1.getCoordy() + largeur);
  }
    
    @Override
     public void dessine(Graphics g) {
         double longueur = this.getSommet().get(1).getCoordx() - this.getSommet().get(0).getCoordx();
         double largeur = this.getSommet().get(2).getCoordy() - this.getSommet().get(0).getCoordy();
        g.setColor(this.getCouleur());
         if(super.isRemplir()){
         g.fillRect((int)this.getSommet().get(0).getCoordx(),(int)this.getSommet().get(0).getCoordy(),(int) longueur,(int)largeur);
         }
         else{
           g.drawRect((int)this.getSommet().get(0).getCoordx(),(int)this.getSommet().get(0).getCoordy(),(int) longueur,(int)largeur);  
         }
     }
   @Override
    public Rectangle copy() {
        return new Rectangle(this);
    }

}
