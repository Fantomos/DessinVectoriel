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
public class Cercle extends Ellipse{
 
    
    public Cercle(){
       this(new Point(),0,"Cercle",Color.BLACK);
    }
    public Cercle(Cercle cercle){
       super(cercle);
    }
    
     public Cercle(Point centre, double rayon){
       this(centre,rayon,"Cercle",Color.BLACK);
    }
    public Cercle(Point centre, double rayon, String nom){
       this(centre,rayon,nom,Color.BLACK);
    }
        
    public Cercle(Point centre, double rayon, String nom, Color couleur){
        super(centre,rayon,rayon,nom,couleur);
       
    }
    
    public void update(double rayon){
        super.setRayonX(rayon);
        super.setRayonY(rayon);
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
    public String toString() {
        return super.getNom() + " : Centre = " + super.getPtSupGauche()+ ", Rayon : " + super.getRayonX() ;
    }

    @Override
    public double distancePoint(Point p){
        return Math.abs(super.getPtSupGauche().distancePoint(p) - super.getRayonX());  
    };

    @Override
     public String toSave(){
        return "C;" + super.getNom() + ";"
                + super.getPtSupGauche().toSave()
                + super.getRayonX() + ";"
                + super.getCouleur() + ";\n"; // ?
    }
      @Override
    public Cercle copy() {
        return new Cercle(this);
    }
    
    
    
    
}
