/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.Lire;

/**
 *
 * @author Nicolas
 */
public class Polygone extends Figure {
    private ArrayList<Point> sommet;
    
    public Polygone(ArrayList<Point> sommet,String nom, Color couleur) {
        super(nom,couleur);
        this.sommet = sommet;
    }
    
    public static Polygone nouveauPolygone(){
       ArrayList<Point> sommet = new ArrayList<Point>();
       System.out.println("Entrez le nom du polygone : ");
       String nom = Lire.S();
       System.out.println("Entrez le nombre de sommet : ");
       int nombreSommet = Lire.i();
       for(int i=0;i<nombreSommet;i++){
         sommet.add(Point.nouveauPoint());
       }
       return new Polygone(sommet,nom,Color.black);
    } 
    
     @Override
    public String toString(){
        String texte = super.getNom() + " = [";
        for(int i=0;i<this.sommet.size();i++){
            texte = texte + sommet.get(i) + "; ";
        }
        texte = texte + "]";
        return texte;
    }
    
    @Override
  public double minX(){
        Point pointMinX =  Collections.min(this.sommet, Comparator.comparing(a -> a.minX()));
        return pointMinX.minX();
    };
    @Override
    public double minY(){
        Figure pointMinY =  Collections.min(this.sommet, Comparator.comparing(a -> a.minY()));
        return pointMinY.minY();
    };
    @Override
    public double maxX(){
        Figure pointMaxX =  Collections.max(this.sommet, Comparator.comparing(a -> a.maxX()));
        return pointMaxX.maxX();
    };
    @Override
    public  double maxY(){
        Figure pointMaxY =  Collections.max(this.sommet, Comparator.comparing(a -> a.maxY()));
        return pointMaxY.maxY();
    };

    @Override
    public double distancePoint(Point p) {
        Point pointProche =  Collections.min(this.sommet, Comparator.comparing(a -> a.distancePoint(p)));
        return pointProche.distancePoint(p);
    }
    public static void main(String[] args) {
        
        Polygone pol = Polygone.nouveauPolygone();
        System.out.println(pol);
    }
}
