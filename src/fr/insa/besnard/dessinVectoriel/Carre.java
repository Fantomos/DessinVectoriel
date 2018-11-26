/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;



/**
 *
 * @author Nicolas
 */
public class Carre extends Rectangle{
   
    // Constructeur
  
    public Carre(Point p1, double longueur, String nom, Color couleur) {
        super(p1, longueur,longueur,nom,couleur);
    }
     public Carre(Point p1, double longueur) {
        this(p1, longueur,"Carre",Color.BLACK);
    }
      public Carre(Carre car) {
        super(car);
    }
      public Carre() {
        this(new Point(),0);
    }
    public void update(Point p1,double longueur){
     this.getSommet().set(0, p1);
      this.getSommet().get(1).setCoordx(p1.getCoordx() + longueur);
       this.getSommet().get(2).setCoordx(p1.getCoordx() + longueur);
       this.getSommet().get(2).setCoordy(p1.getCoordy() + longueur);
       this.getSommet().get(3).setCoordy(p1.getCoordy() + longueur);
  }
     @Override
    public Carre copy() {
        return new Carre(this);
    }
    
}
