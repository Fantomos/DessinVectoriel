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
    
    public Figure entreFigure(){
        int choix = Lire.i();
        if(choix == 0){
            return Point.nouveauPoint();
        }
        else{
            return Segment.nouveauSegment();
        }
    }
    
    public abstract double distancePoint(Point p); 
    
   
}



