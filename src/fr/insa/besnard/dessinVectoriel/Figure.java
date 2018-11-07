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
public abstract class Figure {
    
    private String nom;
    private Color couleur;

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    public Figure(String nom, Color couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }
    
    public static Figure entreFigure(){
        System.out.println("\n0) Point");
        System.out.println("1) Segment");
        int choix = Lire.i();
        if(choix == 0){
            return Point.nouveauPoint();
        }
        else{
            return Segment.nouveauSegment();
        }
    }
    
    
    public abstract Figure symetriqueOrigine();
    public abstract void dessine(Graphics g);
    public abstract String toSave();
    public abstract double minX();
    public abstract double minY();
    public abstract double maxX();
    public abstract double maxY();
    public abstract double distancePoint(Point p); 
    
   
}



