/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import utils.Lire;

/**
 *
 * @author Nicolas
 */
public class Ellipse extends Figure{
    
    private Point ptSupGauche;
    private double rayonX;
    private double rayonY;
    private boolean remplir;

    public boolean isRemplir() {
        return remplir;
    }

    public void setRemplir(boolean remplir) {
        this.remplir = remplir;
    }

   

    public Point getPtSupGauche() {
        return ptSupGauche;
    }

    public void setPtSupGauche(Point centre) {
        this.ptSupGauche = centre;
    }

    public double getRayonX() {
        return rayonX;
    }

    public void setRayonX(double rayonX) {
        this.rayonX = rayonX;
    }
     public double getRayonY() {
        return rayonY;
    }

    public void setRayonY(double rayonY) {
        this.rayonY = rayonY;
    }
     public Ellipse(Ellipse elli) {
        super(elli.getNom(),elli.getCouleur());
        this.ptSupGauche = elli.ptSupGauche;
        this.rayonX = elli.rayonX;
        this.rayonY = elli.rayonY;
        this.remplir = elli.remplir;
  }
     
     public Ellipse(){
        this(new Point(),0,0,"Ellipse",Color.BLACK,false);
    }
    public Ellipse(Point centre, double rayonX, double rayonY){
        this(centre,rayonX,rayonY,"Ellipse",Color.BLACK,false);
    }
    
    public Ellipse(Point centre, double rayonX,double rayonY, String nom){
       this(centre,rayonX,rayonY,nom,Color.BLACK,false);
    }
    public Ellipse(Point centre, double rayonX,double rayonY, String nom,Color couleur){
       this(centre,rayonX,rayonY,nom,couleur,false);
    }
    
    public Ellipse(Point centre, double rayonX, double rayonY, String nom, Color couleur,boolean remplir){
        super(nom,couleur);
        centre.setCoordx(centre.getCoordx() - rayonX);
        centre.setCoordy(centre.getCoordy() - rayonY);
        this.ptSupGauche = centre;
        this.rayonX = rayonX;
        this.rayonY = rayonY;
        this.remplir = remplir;
        
    }
    
  
  
    
    @Override
    public Ellipse symetriqueOrigine() {
        return new Ellipse(this.ptSupGauche.symetriqueOrigine(),this.rayonX,this.rayonY,this.getNom()+"Sym");
    };
    
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        if(remplir){
              g.fillOval((int)(this.ptSupGauche.getCoordx()),(int)(this.ptSupGauche.getCoordy()),(int)(2*this.rayonX),(int)(2*this.rayonY));
        }else{
              g.drawOval((int)(this.ptSupGauche.getCoordx()),(int)(this.ptSupGauche.getCoordy()),(int)(2*this.rayonX),(int)(2*this.rayonY));
        }
      
       
    }
     
     @Override
    public String toString() {
        return super.getNom() + " : Centre = " + ptSupGauche + ", Rayon X : " + rayonX + ", Rayon Y : " + rayonY;
    }

    @Override
    public double minX(){
        return ptSupGauche.getCoordx() - 2*rayonX;
    }
    @Override
    public double minY(){
        return ptSupGauche.getCoordy();
    };
    @Override
    public double maxX(){
        return ptSupGauche.getCoordx();
    };
    @Override
    public double maxY(){
        return ptSupGauche.getCoordy() + 2*rayonY;
    };
    @Override
    public double distancePoint(Point p){
        return Math.abs(ptSupGauche.distancePoint(p) - rayonX);   // A DEFINIR
    };

    @Override
     public String toSave(){
        return "C;" + this.getNom() + ";"
                + this.ptSupGauche.toSave()
                + this.rayonX + ";"
                + this.rayonY + ";"
                + this.getCouleur() + ";\n"; // ?
    }

    @Override
    public Ellipse copy() {
        return new Ellipse(this);
    }

  
  
}
    
    
    
    
