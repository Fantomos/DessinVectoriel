/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;


/**
 *
 * @author Nicolas
 */
public class Carre extends Polygone{
    private double longueurCote;
    private Point centre;
    // Constructeur
  
    public Carre(Point centre, double longueurCote, String nom, Color couleur) {
        super(sommet, nom, couleur);
        
    }
    
    
}
