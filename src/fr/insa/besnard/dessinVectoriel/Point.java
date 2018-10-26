/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.besnard.dessinVectoriel;

import java.awt.Color;
import utils.Lire;

/**
 *
 * @author nbesnard01
 */
public class Point extends Figure{
    private double coordx;
    private double coordy;
    
    public double getCoordx() {
        return coordx;
    }

    public void setCoordx(double coordx) {
        this.coordx = coordx;
    }

    public double getCoordy() {
        return coordy;
    }

    public void setCoordy(double coordy) {
        this.coordy = coordy;
    }
    
    // Constructeur
    public Point() {
        this(0,0,"Point",Color.black);
    }
    
    public Point(double px, double py){
        this(px, py, "Point",Color.black);
    }
    
    public Point(double px,double py, String nom, Color couleur) {
        super(nom,couleur);
        this.coordx = px;
        this.coordy = py;
    }
    
    // Methode création
    public static Point nouveauPoint(){
       System.out.println("Entrez le nom du point : ");
       String nom = Lire.S();
       System.out.println("Entrez l'abscisse : ");
       double x = Lire.d();
       System.out.println("Entrez l'ordonnée : ");
       double y = Lire.d();
       return new Point(x,y,nom,Color.BLACK);
    }
    
    
    //Définition méthode abstract de Figure
    @Override
    public String toString(){
        return super.getNom() + " = (" + this.coordx + "," + this.coordy + ")";
    }
  
    @Override
    public double minX(){
        return this.coordx;
    };
    
    @Override
    public double maxX(){
        return this.coordx;
    };
    
    @Override
     public double minY(){
        return this.coordy;
    };
     
    @Override
    public double maxY(){
        return this.coordy;
    };
    
    @Override
    public double distancePoint(Point p) {
        return Math.sqrt(Math.pow(
                this.coordx-p.coordx,2)+ 
                Math.pow(
                this.coordy-p.coordy,2));
    }
    
    @Override
    public String toSave(){
        return "P;" + this.getNom() + ";"
                + this.coordx + ";"
                + this.coordy + ";"
                + this.getCouleur() + ";\n"; // ?
    };
    
  
 
    
    
    public static void main(String[] args) {
       Point p1 = nouveauPoint();
       Point p2 = nouveauPoint();
       System.out.println(p1.distancePoint(p2));
      
    }
    
}
