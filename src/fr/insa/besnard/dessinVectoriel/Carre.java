/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.util.ArrayList;
import utils.Lire;


/**
 *
 * @author Nicolas
 */
public class Carre extends Rectangle{
   
    // Constructeur
  
    public Carre(ArrayList<Point> sommet, String nom, Color couleur) {
        super(sommet, nom, couleur);
    }
    
    public static Carre nouveauCarre(){
       ArrayList<Point> sommet = new ArrayList<Point>();
       System.out.println("Entrez le nom du carre : ");
       String nom = Lire.S();
       System.out.println("Entrez le premier point : ");
       Point p1 = Point.nouveauPoint();
       System.out.println("Entrez la longueur d'un coté : ");
       double longueur = Lire.d();
       
       sommet.add(new Point (p1.getCoordx() + longueur,p1.getCoordy()));
       sommet.add(new Point (p1.getCoordx() + longueur,p1.getCoordy() + longueur));
       sommet.add(new Point (p1.getCoordx(),p1.getCoordy() + longueur));
       
       return new Carre(sommet,nom,Color.BLACK);
    } 
    
    
}
