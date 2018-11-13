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
    
    private Point centre;
    private double rayonX;
    private double rayonY;

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
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
        this.centre = centre;
        this.rayonX = rayonX;
         this.rayonY = rayonY;
    }
    
    
  
    
    @Override
    public Ellipse symetriqueOrigine() {
        return new Ellipse(this.centre.symetriqueOrigine(),this.rayonX,this.rayonY,this.getNom()+"Sym");
    };
    
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.fillOval((int)(this.centre.getCoordx() - this.rayonX),(int)(this.centre.getCoordy() + this.rayonY),(int)(2*this.rayonX),(int)(2*this.rayonY));
       
    }
     
     @Override
    public String toString() {
        return super.getNom() + " : Centre = " + centre + ", Rayon X : " + rayonX + ", Rayon Y : " + rayonY;
    }

    @Override
    public double minX(){
        return centre.getCoordx() - rayonX;
    }
    @Override
    public double minY(){
        return centre.getCoordy() - rayonY;
    };
    @Override
    public double maxX(){
        return centre.getCoordx() + rayonX;
    };
    @Override
    public double maxY(){
        return centre.getCoordy() + rayonY;
    };
    @Override
    public double distancePoint(Point p){
        return Math.abs(centre.distancePoint(p) - rayonX);   // A DEFINIR
    };

    @Override
     public String toSave(){
        return "C;" + this.getNom() + ";"
                + this.centre.toSave()
                + this.rayonX + ";"
                + this.rayonY + ";"
                + this.getCouleur() + ";\n"; // ?
    }
     
}
    
    
    
    
