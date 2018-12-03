/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import utils.Lire;

/**
 *
 * @author Nicolas
 */
public class Ellipse extends Figure{
    
    private Point center;
    private double rayonX;
    private double rayonY;
    private boolean remplir;

    public boolean isRemplir() {
        return remplir;
    }

    public void setRemplir(boolean remplir) {
        this.remplir = remplir;
    }

     public boolean getRemplir() {
        return remplir;
    }
    
   

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point ptSupGauche) {
        this.center = ptSupGauche;
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
        this.center = elli.center;
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
     
        this.center = centre;
        this.rayonX = rayonX;
        this.rayonY = rayonY;
        this.remplir = remplir;
        
    }
    
  public void deplace(MouseEvent e) {
this.setCenter(new Point(e.getX(),e.getY()));
    }
  
    
    @Override
    public Ellipse symetriqueOrigine() {
        return new Ellipse(this.center.symetriqueOrigine(),this.rayonX,this.rayonY,this.getNom()+"Sym");
    };
    
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        
        if(remplir){
              g.fillOval((int)(this.center.getCoordx() - this.rayonX),(int)(this.center.getCoordy() - this.rayonY),(int)(2*this.rayonX),(int)(2*this.rayonY));
        }else{
              g.drawOval((int)(this.center.getCoordx() - this.rayonX),(int)(this.center.getCoordy() - this.rayonY),(int)(2*this.rayonX),(int)(2*this.rayonY));
        }
      
       
    }
     
     @Override
    public String toString() {
        return super.getNom() + " : Centre = " + center + ", Rayon X : " + rayonX + ", Rayon Y : " + rayonY;
    }

    @Override
    public double minX(){
        return center.getCoordx() - 2*rayonX;
    }
    @Override
    public double minY(){
        return center.getCoordy();
    };
    @Override
    public double maxX(){
        return center.getCoordx();
    };
    @Override
    public double maxY(){
        return center.getCoordy() + 2*rayonY;
    };
    @Override
    public double distancePoint(Point p){
        double distanceCenter = center.distancePoint(p);
 
        return  Math.min(distanceCenter, distanceCenter);
                 // A DEFINIR
                
    };

    @Override
     public String toSave(){
        return "EL;" + this.getNom() + ";"
                + this.remplir + ";"
                + this.center.getCoordx() + ";"
                + this.center.getCoordy() + ";"
                + this.rayonX + ";"
                + this.rayonY + ";"
                + this.getCouleur().getRed() +";" + getCouleur().getBlue() + ";" + getCouleur().getGreen()+";\n";
    }

    @Override
    public Ellipse copy() {
        return new Ellipse(this);
    }

  
  
}
    
    
    
    
