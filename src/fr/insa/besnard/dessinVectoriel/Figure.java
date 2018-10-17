/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public abstract class Figure {
    
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    public Figure(String nom) {
        this.nom = nom;
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
    
    
    public abstract double minX();
    public abstract double minY();
    public abstract double maxX();
    public abstract double maxY();
    public abstract double distancePoint(Point p); 
    
   
}



