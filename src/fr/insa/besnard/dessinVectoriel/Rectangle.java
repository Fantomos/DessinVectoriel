/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
   public void update(double largeur,double longueur){
       this.getSommet().get(1).setCoordx(this.getSommet().get(0).getCoordx() + longueur);
       this.getSommet().get(2).setCoordx(this.getSommet().get(0).getCoordx() + longueur);
       this.getSommet().get(2).setCoordy(this.getSommet().get(0).getCoordy() + largeur);
       this.getSommet().get(3).setCoordy(this.getSommet().get(0).getCoordy() + largeur);
   }
   public void update(Point p1){
      double longueur = this.getSommet().get(1).getCoordx() -  this.getSommet().get(0).getCoordx();
       double largeur = this.getSommet().get(2).getCoordy() -  this.getSommet().get(0).getCoordy();
      update(p1,largeur,longueur);
  }
   
   public Point centre(){
       return new Point((this.getSommet().get(0).getCoordx()+this.getSommet().get(1).getCoordx())/2,(this.getSommet().get(0).getCoordy()+this.getSommet().get(2).getCoordy())/2);
   }
    public double largeur(){
       return this.getSommet().get(2).getCoordy() - this.getSommet().get(0).getCoordy();
   }
    public double longueur(){
       return this.getSommet().get(1).getCoordx() - this.getSommet().get(0).getCoordx();
   }
    
    
   @Override
    public String toSave(){
        return "R;" + this.getNom() + ";" + this.getRemplir() + ";"
                + this.getSommet().get(0).getCoordx() + ";"
                + this.getSommet().get(0).getCoordy()  + ";"
                + this.longueur() + ";"
                + this.largeur() + ";"
                + getCouleur().getRed() + ";" + getCouleur().getGreen() + ";" + getCouleur().getBlue() + ";" + getCouleur().getAlpha();
    };
    
    @Override
    public void deplace(Point2D p) {
        this.update(new Point(p.getX()-this.longueur()/2,p.getY()-this.largeur()/2));
    }
    
    @Override
     public void dessine(Graphics2D g) {
      
        g.setColor(this.getCouleur());
         g.rotate(super.getTheta());
         if(super.isRemplir()){
           g.fill(new Rectangle2D.Double(this.getSommet().get(0).getCoordx(),this.getSommet().get(0).getCoordy(),this.longueur(),this.largeur()));
        
         }
         else{
              g.draw(new Rectangle2D.Double(this.getSommet().get(0).getCoordx(),this.getSommet().get(0).getCoordy(),this.longueur(),this.largeur()));
      
         }
     }
   @Override
    public Rectangle copy() {
        return new Rectangle(this);
    }

}
