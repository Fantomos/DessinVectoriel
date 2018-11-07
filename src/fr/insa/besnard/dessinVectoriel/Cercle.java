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
 * @author nbesnard01
 */
public class Cercle extends Figure{
    private Point centre;
    private double rayon; 

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
    
    public Cercle(Point centre, double rayon, String nom){
       this(centre,rayon,nom,Color.BLACK);
    }
    
    public Cercle(Point centre, double rayon, String nom, Color couleur){
        super(nom,couleur);
        this.centre = centre;
        this.rayon = rayon;
    }
    
    
    public static Cercle nouveauCercle(){
        System.out.println("Entrez le nom du cercle : ");
        String nom = Lire.S();
        System.out.println("Création du centre : ");
        Point centre = Point.nouveauPoint();
        System.out.println("Entrez le rayon : ");
        double rayon = Lire.d();
        return new Cercle(Point.nouveauPoint(),rayon,nom,Color.black);
    }
    
    @Override
    public Cercle symetriqueOrigine() {
        return new Cercle(this.centre.symetriqueOrigine(),this.rayon,this.getNom()+"Sym");
    };
    
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.drawOval((int)(this.centre.getCoordx() - this.rayon),(int)(this.centre.getCoordx() + this.rayon),(int)(2*this.rayon),(int)(2*this.rayon));
    }
     
     @Override
    public String toString() {
        return super.getNom() + " : Centre = " + centre + ", Rayon : " + rayon ;
    }

    @Override
    public double minX(){
        return centre.getCoordx() - rayon;
    }
    @Override
    public double minY(){
        return centre.getCoordy() - rayon;
    };
    @Override
    public double maxX(){
        return centre.getCoordx() + rayon;
    };
    @Override
    public double maxY(){
        return centre.getCoordy() + rayon;
    };
    @Override
    public double distancePoint(Point p){
        return Math.abs(centre.distancePoint(p) - rayon);  
    };

    @Override
     public String toSave(){
        return "C;" + this.getNom() + ";"
                + this.centre.toSave()
                + this.rayon + ";"
                + this.getCouleur() + ";\n"; // ?
    }
     
    
    
    
    
}
