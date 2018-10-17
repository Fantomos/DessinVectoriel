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
    
    public Point() {
        this(0,0,"Point");
    }
    
    public Point(double px, double py){
        this(px, py, "Point");
    }
    
    public Point(double px,double py, String nom) {
        super(nom);
        this.coordx = px;
        this.coordy = py;
    }
    
     @Override
    public String toString(){
        return super.getNom() + " = (" + this.coordx + "," + this.coordy + ")";
    }
  
    public static Point nouveauPoint(){
       System.out.println("Entrez le nom du point : ");
       String nom = Lire.S();
       System.out.println("Entrez l'abscisse : ");
       double x = Lire.d();
       System.out.println("Entrez l'ordonnée : ");
       double y = Lire.d();
       return new Point(x,y,nom);
    }
     
    @Override
    public double distancePoint(Point p) {
        return Math.sqrt(Math.pow(
                this.coordx-p.coordx,2)+ 
                Math.pow(
                this.coordy-p.coordy,2));
    }
    

    
    
   
 
    
    
    public static void main(String[] args) {
       Point p1 = nouveauPoint();
       Point p2 = nouveauPoint();
       System.out.println(p1.distancePoint(p2));
      
    }
    
}
