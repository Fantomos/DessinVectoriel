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
    
    public Ellipse(Point centre, double rayonX,double rayonY, String nom){
       this(centre,rayonX,rayonY,nom,Color.BLACK);
    }
    
    public Ellipse(Point centre, double rayonX, double rayonY, String nom, Color couleur){
        super(nom,couleur);
        centre.setCoordx(centre.getCoordx() - rayonX);
        centre.setCoordy(centre.getCoordy() - rayonY);
        this.ptSupGauche = centre;
        this.rayonX = rayonX;
        this.rayonY = rayonY;
        
    }
    
    public Ellipse(Point centre, double rayonX, double rayonY){
        this(centre,rayonX,rayonY,"Ellipse",Color.BLACK);
    }
    
  
    
    @Override
    public Ellipse symetriqueOrigine() {
        return new Ellipse(this.ptSupGauche.symetriqueOrigine(),this.rayonX,this.rayonY,this.getNom()+"Sym");
    };
    
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.fillOval((int)(this.ptSupGauche.getCoordx()),(int)(this.ptSupGauche.getCoordy()),(int)(2*this.rayonX),(int)(2*this.rayonY));
       
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
     
}
    
    
    
    
