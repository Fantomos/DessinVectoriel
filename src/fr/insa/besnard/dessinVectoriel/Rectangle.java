/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import utils.Lire;

/**
 *
 * @author Nicolas
 */
public class Rectangle extends Polygone{
    
 
    // Constructeur

    public Rectangle(ArrayList<Point> sommet, String nom, Color couleur) {
        super(sommet, nom, couleur);
    }
    public static Rectangle nouveauRectangle(){
       ArrayList<Point> sommet = new ArrayList<Point>();
       System.out.println("Entrez le nom du rectangle : ");
       String nom = Lire.S();
       System.out.println("Entrez le premier point : ");
       Point p1 = Point.nouveauPoint();
       System.out.println("Entrez la largeur : ");
       double largeur = Lire.d();
       System.out.println("Entrez la longueur : ");
       double longueur = Lire.d();
       
       sommet.add(new Point (p1.getCoordx() + longueur,p1.getCoordy()));
       sommet.add(new Point (p1.getCoordx() + longueur,p1.getCoordy() + largeur));
       sommet.add(new Point (p1.getCoordx(),p1.getCoordy() + largeur));
       
       return new Rectangle(sommet,nom,Color.BLACK);
    } 
    public static Rectangle nouveauRectangle(Point p1, double longueur, double largeur,String nom, Color couleur){
       ArrayList<Point> sommet = new ArrayList<Point>();
       sommet.add(new Point (p1.getCoordx() + longueur,p1.getCoordy()));
       sommet.add(new Point (p1.getCoordx() + longueur,p1.getCoordy() + largeur));
       sommet.add(new Point (p1.getCoordx(),p1.getCoordy() + largeur));
       return new Rectangle(sommet,nom,Color.BLACK);
    } 
    
    @Override
     public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.drawRect((int)this.getSommet().get(0).getCoordx(),(int)this.getSommet().get(0).getCoordy(),15,20);
    }
  

}
