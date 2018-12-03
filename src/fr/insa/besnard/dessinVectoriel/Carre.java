/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.event.MouseEvent;



/**
 *
 * @author Nicolas
 */
public class Carre extends Rectangle{
   
    // Constructeur
  public Carre(Point p1, double longueur, String nom, Color couleur,boolean remplir) {
        super(p1, longueur,longueur,nom,couleur,remplir);
    }
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
    public void update(double longueur){

      this.getSommet().get(1).setCoordx(this.getSommet().get(0).getCoordx() + longueur);
       this.getSommet().get(2).setCoordx(this.getSommet().get(0).getCoordx() + longueur);
       this.getSommet().get(2).setCoordy(this.getSommet().get(0).getCoordy() + longueur);
       this.getSommet().get(3).setCoordy(this.getSommet().get(0).getCoordy() + longueur);
  }
    
  @Override
    public void deplace(MouseEvent e) {
         this.update(new Point(e.getX()-this.longueur()/2,e.getY()-this.longueur()/2));
    }
    
    
     @Override
    public Carre copy() {
        return new Carre(this);
    }
    
    @Override
    public String toSave(){ 
        return "CA;" + this.getNom() + ";" + this.getRemplir() + ";"
                + this.getSommet().get(0).getCoordx() + ";"
                + this.getSommet().get(0).getCoordy()  + ";"
                + this.longueur() + ";"
                + this.getCouleur().getRed() +";" + getCouleur().getBlue() + ";" + getCouleur().getGreen();
    };
    
}
